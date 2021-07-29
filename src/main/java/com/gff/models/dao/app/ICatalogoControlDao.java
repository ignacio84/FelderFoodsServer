
package com.gff.models.dao.app;

import com.gff.models.entity.app.CatalogoControl;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ICatalogoControlDao extends CrudRepository<CatalogoControl, Integer> {
    
//    @Query("select c from CatalogoControl c where c.username=?1")
//    public List<CatalogoControl> findAll();
    
}
