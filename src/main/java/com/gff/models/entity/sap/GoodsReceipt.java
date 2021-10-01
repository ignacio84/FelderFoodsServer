package com.gff.models.entity.sap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/*Representa tabla del sistema SAP. OIGN - Terminacion report, Entrada de mercancías*/
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "OIGN")
public class GoodsReceipt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer docEntry;

    //Número de terminacion report.
    private Integer docNum;


    //Comentarios
    private String Comments;
    
    @JsonIgnoreProperties({"docEntry"})
    @OneToMany(mappedBy = "docEntry", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<GoodsReceiptLines> goodsReceiptLines = new ArrayList<>();

    public Integer getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    public Integer getDocNum() {
        return docNum;
    }

    public void setDocNum(Integer docNum) {
        this.docNum = docNum;
    }


    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public List<GoodsReceiptLines> getGoodsReceiptLines() {
        return goodsReceiptLines;
    }

    public void setGoodsReceiptLines(List<GoodsReceiptLines> goodsReceiptLines) {
        this.goodsReceiptLines = goodsReceiptLines;
    }

    @Override
    public String toString() {
        return "GoodsReceipt{" + "docEntry=" + docEntry + ", docNum=" + docNum + ", Comments=" + Comments + ", goodsReceiptLines=" + goodsReceiptLines + '}';
    }

    
}
