package com.gff.models.entity.sap;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*Representa tabla del sistema SAP. OITM - Articulos*/
@Entity
@Table(name = "OITM")
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;

    //Número de artículo.
    @Id
    private String itemCode;
    
    //Nombre del artículo.
    private String itemName;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String ItemCode) {
        this.itemCode = ItemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String ItemName) {
        this.itemName = ItemName;
    }

    @Override
    public String toString() {
        return "Articulo{" + "ItemCode=" + itemCode + ", ItemName=" + itemName + '}';
    }

}
