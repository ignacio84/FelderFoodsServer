
package com.spring.app.controllers;

import com.spring.app.models.entity.sqlserver.Menu;
import com.spring.app.models.services.sqlserver.IMenuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/insumos")
public class MenuController {
    
    @Autowired
    private IMenuService menuService;
    
    
    @GetMapping("/menu")
    public List<Menu> getMenu() {
        return this.menuService.getMenu();
    }
    
}
