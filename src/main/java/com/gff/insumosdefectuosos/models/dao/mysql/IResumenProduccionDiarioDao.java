package com.gff.insumosdefectuosos.models.dao.mysql;
import com.gff.insumosdefectuosos.models.entity.mysql.ResumenProduccionDiario;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IResumenProduccionDiarioDao extends JpaRepository<ResumenProduccionDiario, Integer> {
    @Query("select a from ResumenProduccionDiario a where a.fechaMovimiento between ?1 and ?2")
    public List<ResumenProduccionDiario> findByBetweenDate(Timestamp dateFrom, Timestamp datTo);
}
