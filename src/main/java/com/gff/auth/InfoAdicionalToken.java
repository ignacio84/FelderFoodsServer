package com.gff.auth;

import com.gff.models.entity.app.Usuario;
import com.gff.models.services.app.UsuarioService;
import java.util.HashMap;
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
    
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication oaa) {
        Usuario usuario = usuarioService.findByUserName(oaa.getName());
        usuario.setPassword("");
        Map<String, Object> info = new HashMap<>();
        info.put("nombre", usuario.getNombre());
        info.put("apellido", usuario.getApellido());
        info.put("username",usuario.getUsername());
        info.put("email", usuario.getEmail());
        info.put("id", usuario.getId());
        info.put("perfil",usuario.getPerfil());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
