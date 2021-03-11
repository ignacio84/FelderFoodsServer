package com.gff.insumosdefectuosos.controllers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gff.insumosdefectuosos.models.entity.mysql.ResumenProduccionDiario;
import com.gff.insumosdefectuosos.models.entity.sqlserver.Articulo;
import com.gff.insumosdefectuosos.models.services.mysql.IResumenProduccionDiarioService;
import com.gff.insumosdefectuosos.models.services.sqlserver.IArticuloService;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insumos")
//@CrossOrigin(origins = {"http://192.168.1.15:4200", "http://localhost:4200"})
@CrossOrigin(origins = {"http://192.168.1.15:4200"})
public class InsumosDefectuososController {

    @Autowired
    private IArticuloService serviceArticulo;

    @Autowired
    private IResumenProduccionDiarioService serviceProdDiario;

    @Secured({"ROLE_ADMIN", "ROLE_CONINS"})
    @GetMapping("/all")
    public List<ResumenProduccionDiario> getAll() {
        return serviceProdDiario.getAll();
    }

//    @Secured({"ROLE_ADMIN", "ROLE_CONINS"})
    @PostMapping("/postArticulos")
    public ResponseEntity<?> postArticulos(@RequestBody Map<String, Object> obj) {
        Map<String, Object> response = new HashMap<>();
        List<String> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            list = mapper.convertValue(obj.get("articulos"), List.class);
            response.put("articulos", serviceArticulo.findByItemName(list));
        } catch (Exception e) {
            response.put("msj", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping("/postInsumos")
    public ResponseEntity<?> postInsumos(@RequestBody Map<String, Object> obj) {
        Date dateFrom;
        Date dateTo;
        Map<String, Object> response = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            dateFrom = mapper.convertValue(obj.get("dateFrom"), Date.class);
            dateTo = mapper.convertValue(obj.get("dateTo"), Date.class);
            response.put("insumos", serviceProdDiario.findByBetweenDate(dateFrom, dateTo));
        } catch (Exception e) {
            response.put("msj", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
