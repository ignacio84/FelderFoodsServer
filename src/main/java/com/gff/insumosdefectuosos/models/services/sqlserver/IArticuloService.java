package com.gff.insumosdefectuosos.models.services.sqlserver;

import com.gff.insumosdefectuosos.models.entity.sqlserver.Articulo;
import java.util.List;

public interface IArticuloService {
    
    public List<Articulo> findByItemName(List<String> list);
    
}
