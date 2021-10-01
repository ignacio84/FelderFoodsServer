
package com.gff.models.entity.sap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*Representa tabla del sistema SAP. OIGN - Terminacion report lineas, Entrada de mercancías lineas*/
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "IGN1")
public class GoodsReceiptLines implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer docEntry;
    
    private Integer lineNum;
    
    private Integer baseRef;
    
    private Integer baseEntry;
    
    private String lineStatus;
    
    private String itemCode;
    
    private String dscription;
    
    private String openQty;
    
    private String price;
    
    private String currency;
    
    private String lineTotal;

    public Integer getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    public Integer getLineNum() {
        return lineNum;
    }

    public void setLineNum(Integer lineNum) {
        this.lineNum = lineNum;
    }

    public Integer getBaseRef() {
        return baseRef;
    }

    public void setBaseRef(Integer baseRef) {
        this.baseRef = baseRef;
    }

    public Integer getBaseEntry() {
        return baseEntry;
    }

    public void setBaseEntry(Integer baseEntry) {
        this.baseEntry = baseEntry;
    }

    public String getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDscription() {
        return dscription;
    }

    public void setDscription(String dscription) {
        this.dscription = dscription;
    }

    public String getOpenQty() {
        return openQty;
    }

    public void setOpenQty(String openQty) {
        this.openQty = openQty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(String lineTotal) {
        this.lineTotal = lineTotal;
    }

    @Override
    public String toString() {
        return "GoodsReceiptLines{" + "docEntry=" + docEntry + ", lineNum=" + lineNum + ", baseRef=" + baseRef + ", baseEntry=" + baseEntry + ", lineStatus=" + lineStatus + ", itemCode=" + itemCode + ", dscription=" + dscription + ", openQty=" + openQty + ", price=" + price + ", currency=" + currency + ", lineTotal=" + lineTotal + '}';
    }
}
