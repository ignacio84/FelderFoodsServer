
package com.gff.models.services.sap;

import com.gff.models.entity.sap.OrdenFabricacion;
import java.util.List;

public interface IOrdenFabricacionService {
    
    public OrdenFabricacion findById(Integer id);
    
    public List<OrdenFabricacion> findAll();
    
    public List<OrdenFabricacion> findAllOpen();
    
    
    
}
