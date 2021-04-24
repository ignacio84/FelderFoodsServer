package com.spring.app.models.dao.sqlserver;

import com.spring.app.models.entity.sqlserver.Menu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IMenuDao extends JpaRepository<Menu, String> {

    @Query("select m from Menu m where m.clavePadre=?1 ")
    public List<Menu> findByClavePadre(String clave);

//    public List<Menu> getMenu();
}
