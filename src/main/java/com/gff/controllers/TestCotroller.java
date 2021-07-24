
package com.gff.controllers;

import com.gff.models.entity.app.Usuario;
import com.gff.models.services.app.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCotroller {
    
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Secured({"ROLE_ADMIN", "ROLE_PROD"})
    @GetMapping("/usuario")
    public Usuario menu() {
        return this.usuarioService.findByUserName("icastro");
    }
}
