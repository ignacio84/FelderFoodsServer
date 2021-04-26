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
        this.buildMenuTree(menu);
        return menu;
    }
    
    
    /*METODO GENERA ARREGLO CON EL ARBOL DEL MENU*/
    private void buildMenuTree(List<Menu> list){
        for (int i = 0; i < list.size(); i++) {
            if (this.findByClavePadre(list.get(i).getClave()).size()>0){
                list.get(i).setSubMenu(this.findByClavePadre(list.get(i).getClave()));
                this.buildMenuTree(list.get(i).getSubMenu());
            }
        }
    }
    
    /*METODO BUSCA POR CLAVE DEL PADRE EN EL LISTADO DEL MENU*/
    private List<Menu> findByClavePadre(String clavePadre) {
        return this.fullMenu
                .stream()
                .filter(x -> clavePadre.equals(x.getClavePadre()))
                .collect(Collectors.toList());
    }
}
