package com.gff.models.entity.sap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/*Representa tabla del sistema SAP. OWOR - Orden de fabricación*/
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "OWOR")
public class ProductionOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer docEntry;

    //Número de orden de fabricación.
    private Integer docNum;

    //Estado.
    private String status;

    //Número de producto.
    @Column(name = "ItemCode", insertable = false, updatable = false)
    private String itemCode;

    //Almacén de destino.
    private String wareHouse;

    //Fecha de inicio.
    private Date startDate;

    //Fecha de inicio.
    private Date closeDate;

    //Fecha de cierre real.
    private String plannedQty;

    //Cantidad completada.
    private String cmpltQty;
    
    @JsonIgnoreProperties({"ItemCode"})
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ItemCode", referencedColumnName = "ItemCode", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Items items;

    public Integer getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Integer DocEntry) {
        this.docEntry = DocEntry;
    }

    public Integer getDocNum() {
        return docNum;
    }

    public void setDocNum(Integer DocNum) {
        this.docNum = DocNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String ItemCode) {
        this.itemCode = ItemCode;
    }

    public String getWarehouse() {
        return wareHouse;
    }

    public void setWarehouse(String Warehouse) {
        this.wareHouse = Warehouse;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date StartDate) {
        this.startDate = StartDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date CloseDate) {
        this.closeDate = CloseDate;
    }

    public String getPlannedQty() {
        if (plannedQty != null) {
            this.plannedQty = String.format("%.4f", Double.valueOf(plannedQty));
        }
        return plannedQty;
    }

    public void setPlannedQty(String PlannedQty) {
        this.plannedQty = PlannedQty;
    }

    public String getCmpltQty() {
        if (cmpltQty != null) {
            this.cmpltQty = String.format("%.4f", Double.valueOf(cmpltQty));
        }
        return cmpltQty;
    }

    public void setCmpltQty(String CmpltQty) {
        this.cmpltQty = CmpltQty;

    }

    public String getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(String wareHouse) {
        this.wareHouse = wareHouse;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrdenFabricacion{" + "docEntry=" + docEntry + ", docNum=" + docNum + ", status=" + status + ", itemCode=" + itemCode + ", wareHouse=" + wareHouse + ", startDate=" + startDate + ", closeDate=" + closeDate + ", plannedQty=" + plannedQty + ", cmpltQty=" + cmpltQty + ", items=" + items + '}';
    }
}