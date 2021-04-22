
package com.spring.app.models.dao.sqlserver;

import com.spring.app.models.entity.sqlserver.Menu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuDao extends JpaRepository<Menu, String> {
    
//    public List<Menu> getMenu();
    
}
