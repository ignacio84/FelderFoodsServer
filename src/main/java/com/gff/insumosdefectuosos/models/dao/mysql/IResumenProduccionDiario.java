
package com.gff.insumosdefectuosos.models.dao.mysql;

import com.gff.insumosdefectuosos.models.entity.mysql.ResumenProduccionDiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResumenProduccionDiario extends JpaRepository<ResumenProduccionDiario, Integer> {
    
}
