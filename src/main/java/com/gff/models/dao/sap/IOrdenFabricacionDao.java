package com.gff.models.dao.sap;

import com.gff.models.entity.sap.OrdenFabricacion;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IOrdenFabricacionDao extends CrudRepository<OrdenFabricacion, Integer> {

    //P:PLANIFICADO, R:LIBERADO, L:CERRADO, C:CANCELADO
    @Query(" SELECT O "
            + " FROM OrdenFabricacion O   " 
            + " WHERE   O.Status='R'  "
            + " ORDER BY O.StartDate DESC")
    public List<OrdenFabricacion> findAllOpen();

}
