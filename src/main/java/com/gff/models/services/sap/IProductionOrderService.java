
package com.gff.models.services.sap;

import com.gff.models.entity.sap.ProductionOrder;
import java.util.List;

public interface IProductionOrderService {
    
    public ProductionOrder findById(Integer id);
    
    public List<ProductionOrder> findAll();
    
    public List<ProductionOrder> findAllOpen();
    
    
    
}
