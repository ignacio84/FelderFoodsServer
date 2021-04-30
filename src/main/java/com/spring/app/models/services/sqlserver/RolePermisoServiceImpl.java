package com.spring.app.models.services.sqlserver;

import com.spring.app.models.dao.sqlserver.IRolePermisoDao;
import com.spring.app.models.entity.sqlserver.RolePermiso;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermisoServiceImpl implements IRolePermisoService {

    private List<RolePermiso> permisos = new ArrayList<>();
    private List<RolePermiso> fullPermisos = new ArrayList<>();

    @Autowired
    private IRolePermisoDao permisoDao;

    @Override
    public List<RolePermiso> findByRole(String role) {
        this.fullPermisos = this.permisoDao.findByRole(role);
        this.permisos = this.findByClavePadre("MAIN");
        this.buildMenuTree(permisos);
        return permisos;
    }
    
      
    /*METODO GENERA ARREGLO CON EL ARBOL DEL MENU*/
    private void buildMenuTree(List<RolePermiso> list){
        for (int i = 0; i < list.size(); i++) {
            if (this.findByClavePadre(list.get(i).getClave()).size()>0){
                list.get(i).setSubMenu(this.findByClavePadre(list.get(i).getClave()));
                this.buildMenuTree(list.get(i).getSubMenu());
            }
        }
    }
    
    /*METODO BUSCA POR CLAVE DEL PADRE EN EL LISTADO DEL MENU*/
    private List<RolePermiso> findByClavePadre(String clavePadre) {
        return this.fullPermisos
                .stream()
                .filter(x -> clavePadre.equals(x.getClavePadre()))
                .collect(Collectors.toList());
    }

}
