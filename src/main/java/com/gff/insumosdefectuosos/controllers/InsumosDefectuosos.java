
package com.gff.insumosdefectuosos.controllers;

import com.gff.insumosdefectuosos.models.dao.mysql.IResumenProduccionDiario;
import com.gff.insumosdefectuosos.models.entity.mysql.ResumenProduccionDiario;
import com.gff.insumosdefectuosos.models.services.mysql.IResumenProduccionDiarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insumos")
//@CrossOrigin(origins = {"http://192.168.1.15:4200", "http://localhost:4200"})
@CrossOrigin(origins = {"http://192.168.1.17:4200"})
public class InsumosDefectuosos {
    
    @Autowired
    private IResumenProduccionDiarioService serviceProdDiario;
    
    @Secured({"ROLE_ADMIN", "ROLE_CONINS"})
    @GetMapping("/all")
    public List<ResumenProduccionDiario> findConfigByIp() {
        return serviceProdDiario.getAll();
    }
}
