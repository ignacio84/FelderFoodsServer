package com.gff.models.entity.sap;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*Representa tabla del sistema SAP. OITM - Articulos*/
@Entity
@Table(name = "OITM")
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    //Número de artículo.
    @Id
    private String ItemCode;
    
    //Nombre del artículo.
    private String ItemName;

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

    @Override
    public String toString() {
        return "Articulo{" + "ItemCode=" + ItemCode + ", ItemName=" + ItemName + '}';
    }

}
