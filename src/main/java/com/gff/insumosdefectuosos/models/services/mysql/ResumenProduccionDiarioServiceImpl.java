
package com.gff.insumosdefectuosos.models.services.mysql;

import com.gff.insumosdefectuosos.models.entity.mysql.ResumenProduccionDiario;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gff.insumosdefectuosos.models.dao.mysql.IResumenProduccionDiarioDao;
import java.sql.Timestamp;

@Service
public class ResumenProduccionDiarioServiceImpl implements IResumenProduccionDiarioService{
    
    @Autowired
    private IResumenProduccionDiarioDao resumenProdDiario;
    
    @Override
    @Transactional(readOnly = true)
    public List<ResumenProduccionDiario> getAll() {
        return this.resumenProdDiario.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<ResumenProduccionDiario> findByBetweenDate(Timestamp dateFrom, Timestamp datTo) {
        return this.resumenProdDiario.findByBetweenDate(dateFrom, datTo);
    }
}
