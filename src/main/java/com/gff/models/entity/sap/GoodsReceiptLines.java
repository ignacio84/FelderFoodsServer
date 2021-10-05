package com.gff.models.entity.sap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

/*Representa tabla del sistema SAP. OIGN - Terminacion report lineas, Entrada de mercancías lineas*/
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "IGN1")
@IdClass(GoodsReceiptLinesPK.class)
public class GoodsReceiptLines implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer docEntry;

    @Id
    private Integer lineNum;

    private Integer baseRef;

    private String quantity;

    @Transient
    private String lote;

    @Transient
    private List<Batch> batches;

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public List<Batch> getBatches() {
        return batches;
    }

    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }

    @Override
    public String toString() {
        return "GoodsReceiptLines{" + "docEntry=" + docEntry + ", lineNum=" + lineNum + ", baseRef=" + baseRef + ", quantity=" + quantity + ", lote=" + lote + ", batches=" + batches + '}';
    }

}
