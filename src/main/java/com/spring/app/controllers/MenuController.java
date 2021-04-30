package com.spring.app.controllers;

import com.spring.app.models.entity.sqlserver.Menu;
import com.spring.app.models.entity.sqlserver.RolePermiso;
import com.spring.app.models.services.sqlserver.IMenuService;
import com.spring.app.models.services.sqlserver.IRolePermisoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/insumos")
public class MenuController {

    @Autowired
    private IMenuService menuService;
    
    @Autowired
    private IRolePermisoService permisoService;

    @GetMapping("/menu")
    public List<Menu> menu() {
        return this.menuService.findMenu();
    }
    
    
    @GetMapping("/permisos/{role}")
    public List<RolePermiso> permiso(@PathVariable String role) {
        return this.permisoService.findByRole(role);
    }
    
    
    
//      @GetMapping("/menuByClavePadre/{clavePadre}")
//    public List<Menu> getMenu(@PathVariable String clavePadre) {
//        return this.menuService.findMenuByClavePadre(clavePadre);
    }
