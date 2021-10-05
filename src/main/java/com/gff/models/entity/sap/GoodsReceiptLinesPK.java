package com.gff.models.entity.sap;

import java.io.Serializable;
import java.util.Objects;

public class GoodsReceiptLinesPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer docEntry;

    private Integer lineNum;

    public GoodsReceiptLinesPK () {
    }

    public GoodsReceiptLinesPK (Integer cocEntry, Integer lineNum) {
        this.docEntry = docEntry;
        this.lineNum = lineNum;
    }

    public Integer getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Integer DocEntry) {
        this.docEntry = DocEntry;
    }

    public Integer getLineNum() {
        return lineNum;
    }

    public void setLineNum(Integer LineNum) {
        this.lineNum = LineNum;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GoodsReceiptLinesPK  other = (GoodsReceiptLinesPK ) obj;
        if (!Objects.equals(this.docEntry, other.docEntry)) {
            return false;
        }
        if (!Objects.equals(this.lineNum, other.lineNum)) {
            return false;
        }
        return true;
    }

}
