
package com.gff.models.entity.sap;

public class Batch {
    
    //nombre del lote
    private String itemName;
    
    //unidad de medida
    private String um;
    
    //cantidad
    private String quantity;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Batch{" + "itemName=" + itemName + ", um=" + um + ", quantity=" + quantity + '}';
    }
       
}
