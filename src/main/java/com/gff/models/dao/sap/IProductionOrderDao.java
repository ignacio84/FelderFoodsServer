package com.gff.models.dao.sap;
import com.gff.models.entity.sap.ProductionOrder;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IProductionOrderDao extends CrudRepository<ProductionOrder, Integer> {

    //P:PLANIFICADO, R:LIBERADO, L:CERRADO, C:CANCELADO
    @Query(" SELECT O "
            + " FROM ProductionOrder O   " 
            + " WHERE   O.status='R'  "
            + " ORDER BY O.startDate DESC ")
    public List<ProductionOrder> findAllOpen();

}
