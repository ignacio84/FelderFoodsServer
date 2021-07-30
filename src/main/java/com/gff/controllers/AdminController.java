
package com.gff.controllers;

import com.gff.models.entity.app.CatalogoControl;
import com.gff.models.services.app.ICatalogoControlService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = {"http://192.168.1.150:4200","http://192.168.1.15:4200", "http://localhost:4200", "http://192.168.1.4:4200"})
public class AdminController {
    
    @Autowired
    @Qualifier("CatalogoControlServices")
    private ICatalogoControlService ccService;
    
//    @Secured({"ROLE_ADMIN"})
    @GetMapping("allControls")
    public List<CatalogoControl> allControls() {
        return this.ccService.findAll();
    }
    
}
