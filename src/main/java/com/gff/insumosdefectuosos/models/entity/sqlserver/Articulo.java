
package com.gff.insumosdefectuosos.models.entity.sqlserver;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OITM")
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String ItemCode;

    private String ItemName;
    
    //GRUPO DE ARTICULOS
    private Integer ItmsGrpCod;
    
    //ARTICULO PARA VENTA
    private String SellItem;
    
    //ARTICULO ACTIVO=Y INACTIVO=N
    private String validFor;
    
    
//    //GRUPO DE ARTICULOS
//    @JsonIgnoreProperties({"ItmsGrpCod"})
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "ItmsGrpCod", referencedColumnName = "ItmsGrpCod", insertable = false, updatable = false)
//    @NotFound(action = NotFoundAction.IGNORE)
//    private GrupoArticulo grupoArticulo;

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public Integer getItmsGrpCod() {
        return ItmsGrpCod;
    }

    public void setItmsGrpCod(Integer ItmsGrpCod) {
        this.ItmsGrpCod = ItmsGrpCod;
    }

    public String getSellItem() {
        return SellItem;
    }

    public void setSellItem(String SellItem) {
        this.SellItem = SellItem;
    }

    public String getValidFor() {
        return validFor;
    }

    public void setValidFor(String validFor) {
        this.validFor = validFor;
    }
//
//    public GrupoArticulo getGrupoArticulo() {
//        return grupoArticulo;
//    }
//
//    public void setGrupoArticulo(GrupoArticulo grupoArticulo) {
//        this.grupoArticulo = grupoArticulo;
//    }

    @Override
    public String toString() {
        return "Articulo{" + "ItemCode=" + ItemCode + ", ItemName=" + ItemName + ", ItmsGrpCod=" + ItmsGrpCod + ", SellItem=" + SellItem + ", validFor=" + validFor + '}';
    }

}