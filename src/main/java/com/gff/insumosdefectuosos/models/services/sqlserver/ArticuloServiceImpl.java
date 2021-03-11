package com.gff.insumosdefectuosos.models.services.sqlserver;

import com.gff.insumosdefectuosos.models.dao.sqlserver.IArticuloDao;
import com.gff.insumosdefectuosos.models.entity.sqlserver.Articulo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements IArticuloService{

    @Autowired
    private IArticuloDao articuloDao;
    
    
    @Transactional(readOnly = true)
    @Override
    public List<Articulo> findByItemName(List<String> list) {
       return this.articuloDao.findAllById(list);
    }
}
