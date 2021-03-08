package com.gff.insumosdefectuosos.models.services.mysql;

import com.gff.insumosdefectuosos.models.dao.mysql.IUsuarioDao;
import com.gff.insumosdefectuosos.models.entity.mysql.Usuario;
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
        Usuario usuario = usuarioDao.findByUsername(username);

        if (usuario == null) {
            System.out.println("Error en el login: no existe usuario '" + username + "' en el sistema");
            throw new UsernameNotFoundException("Error en el login: no existe usuario '" + username + "' en el sistema");
        }
        List<GrantedAuthority> roles = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .peek(auth -> System.out.println(auth.getAuthority()))
                .collect(Collectors.toList());
        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, roles);
    }

    @Transactional(readOnly = true)
    public Usuario findByUserName(String username) {
        return usuarioDao.findByUsername(username);
    }
}
