package com.gff.models.services.app;

import com.gff.models.dao.app.IUsuarioDao;
import com.gff.models.entity.app.Usuario;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("UsuarioService")
public class UsuarioService implements UserDetailsService {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername2(username);
        List<GrantedAuthority> grathRoles=null;
        if (usuario == null) {
            System.out.println("Error en el login: no existe usuario '" + username + "' en el sistema");
            throw new UsernameNotFoundException("Error en el login: no existe usuario '" + username + "' en el sistema");
        }

        List<String> roles = usuario.getPerfil().getPerfilDetalle()
                .stream()
                .map(data -> data.getCatalogoControl())
                .filter(data -> data.getNombre().indexOf("ROLE_") != -1)
                .map(role -> role.getNombre())
                .collect(Collectors.toList());

        if (roles.size() > 0) {//si existe por lo menos un rol activo.
            grathRoles = usuario.getPerfil().getPerfilDetalle()
                    .stream()
                    .map(data -> data.getCatalogoControl())
                    .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                    .collect(Collectors.toList());
        }else{
             throw new UsernameNotFoundException( username + "' : unauthorized");
        }
        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, grathRoles);
    }

    @Transactional(readOnly = true)
    public Usuario findByUserName(String username) {
        return usuarioDao.findByUsername(username);
    }
}
