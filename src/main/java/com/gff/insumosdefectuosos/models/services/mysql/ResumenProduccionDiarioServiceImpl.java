
package com.gff.insumosdefectuosos.models.services.mysql;

import com.gff.insumosdefectuosos.models.dao.mysql.IResumenProduccionDiario;
import com.gff.insumosdefectuosos.models.entity.mysql.ResumenProduccionDiario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResumenProduccionDiarioServiceImpl implements IResumenProduccionDiarioService{
    
    @Autowired
    private IResumenProduccionDiario resumenProdDiario;
    
    @Override
    @Transactional(readOnly = true)
    public List<ResumenProduccionDiario> getAll() {
        return this.resumenProdDiario.findAll();
    }
}
