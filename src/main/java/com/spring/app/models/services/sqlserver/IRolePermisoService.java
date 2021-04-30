
package com.spring.app.models.services.sqlserver;

import com.spring.app.models.entity.sqlserver.RolePermiso;
import java.util.List;

public interface IRolePermisoService {
    
    public List<RolePermiso> findByRole(String role);
    
}
