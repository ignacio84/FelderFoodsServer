package com.gff.insumosdefectuosos.models.services.mysql;

import com.gff.insumosdefectuosos.models.entity.mysql.ResumenProduccionDiario;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface IResumenProduccionDiarioService {

    public List<ResumenProduccionDiario> getAll();

    public List<ResumenProduccionDiario> findByBetweenDate(Timestamp dateFrom, Timestamp datTo);

}
