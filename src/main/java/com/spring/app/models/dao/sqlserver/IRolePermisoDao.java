
package com.spring.app.models.dao.sqlserver;

import com.spring.app.models.entity.sqlserver.Menu;
import com.spring.app.models.entity.sqlserver.RolePermiso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IRolePermisoDao extends JpaRepository<RolePermiso, String> {
    
     @Query("select rp from RolePermiso rp where rp.role=?1 ")
    public List<RolePermiso> findByRole(String clave);
    
}
