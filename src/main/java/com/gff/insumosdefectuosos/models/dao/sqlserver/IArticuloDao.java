package com.gff.insumosdefectuosos.models.dao.sqlserver;
import com.gff.insumosdefectuosos.models.entity.sqlserver.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IArticuloDao extends JpaRepository<Articulo, String> {
    
    @Query("select a from Articulo a where a.ItemName=?1")
    public Articulo findByItemName(String itemName);
    
}
