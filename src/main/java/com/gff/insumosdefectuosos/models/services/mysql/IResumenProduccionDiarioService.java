
package com.gff.insumosdefectuosos.models.services.mysql;

import com.gff.insumosdefectuosos.models.entity.mysql.ResumenProduccionDiario;
import java.util.List;

public interface IResumenProduccionDiarioService {
    
   public List<ResumenProduccionDiario> getAll();
    
}
