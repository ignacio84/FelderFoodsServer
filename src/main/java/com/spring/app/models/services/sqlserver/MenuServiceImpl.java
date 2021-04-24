package com.spring.app.models.services.sqlserver;

import com.spring.app.models.dao.sqlserver.IMenuDao;
import com.spring.app.models.entity.sqlserver.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuServiceImpl implements IMenuService {

    private List<Menu> menu = new ArrayList<>();
    private List<Menu> fullMenu = new ArrayList<>();

    @Autowired
    private IMenuDao menuDao;

    @Transactional(readOnly = true)
    @Override
    public List<Menu> findMenu() {
        this.fullMenu = this.menuDao.findAll();
        this.menu = this.findByClavePadre("MAIN");
        for (Menu menu1 : menu) {
            menu1.setSubMenu(this.findByClavePadre(menu1.getClave()));
            for (Menu menu2 : menu1.getSubMenu()) {
                menu2.setSubMenu(this.findByClavePadre(menu2.getClave()));
                for (Menu menu3 : menu2.getSubMenu()) {
                    menu3.setSubMenu(this.findByClavePadre(menu3.getClave()));
                    for (Menu menu4 : menu3.getSubMenu()) {
                        menu4.setSubMenu(this.findByClavePadre(menu4.getClave()));
                        for (Menu menu5 : menu4.getSubMenu()) {
                            menu5.setSubMenu(this.findByClavePadre(menu5.getClave()));
                        }
                    }
                }
            }
        }
        return menu;
    }

    private List<Menu> findByClavePadre(String clavePadre) {
        return this.fullMenu
                .stream()
                .filter(x -> clavePadre.equals(x.getClavePadre()))
                .collect(Collectors.toList());
    }
}
