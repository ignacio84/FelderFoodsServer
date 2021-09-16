
package com.gff.controllers;

import com.gff.models.entity.app.CatalogoControl;
import com.gff.models.entity.sap.OrdenFabricacion;
import com.gff.models.services.sap.IOrdenFabricacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Secured({"ROLE_ADMIN","ROLE_PROD"})
@RequestMapping("/prod")
@CrossOrigin(origins = {"http://192.168.1.150:4200","http://192.168.1.15:4200", "http://localhost:4200", "http://192.168.1.4:4200"})
public class ProduccionController {
    
    @Autowired
    private IOrdenFabricacionService ofcServices;
    
    //Todas las ordenes de fabricacion en estatus abierto.
    @GetMapping("findAllOpenOrf")
    public List<OrdenFabricacion> findAllOpenOrf() {
        return this.ofcServices.findAllOpen();
    }
    
    
    @GetMapping("findByIdOrf/{id}")
    public OrdenFabricacion findByIdOrf(@PathVariable Integer id) {
        return this.ofcServices.findById(id);
    }
}
