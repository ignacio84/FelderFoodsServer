package com.spring.app.auth;

import com.spring.app.models.entity.sqlserver.Usuario;
import com.spring.app.models.services.sqlserver.IRolePermisoService;
import com.spring.app.models.services.sqlserver.UsuarioService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private IRolePermisoService permisoService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication oaa) {
        Usuario usuario = usuarioService.findByUserName(oaa.getName());
        usuario.setPassword("");
        Map<String, Object> info = new HashMap<>();
        info.put("nombre", usuario.getNombre());
        info.put("apellido", usuario.getApellido());
        info.put("email", usuario.getEmail());
        info.put("id", usuario.getId());
        info.put("permiso", this.permisoService.findByRole(usuario.getRoles().get(0).getNombre()));
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
