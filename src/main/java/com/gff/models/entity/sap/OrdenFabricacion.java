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
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/*Representa tabla del sistema SAP. OWOR - Orden de fabricación*/
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "OWOR")
public class OrdenFabricacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer DocEntry;

    //Número de orden de fabricación.
    private Integer DocNum;

    //Estado.
    private String Status;

    //Número de producto.
    @Column(name = "ItemCode", insertable = false, updatable = false)
    private String ItemCode;

    //Almacén de destino.
    private String Warehouse;

    //Fecha de inicio.
    private Date StartDate;

    //Fecha de inicio.
    private Date CloseDate;

    //Fecha de cierre real.
    private String PlannedQty;

    //Cantidad completada.
    private String CmpltQty;

    @JsonIgnoreProperties({"ItemCode"})
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ItemCode", referencedColumnName = "ItemCode", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Articulo articulo;

    public Integer getDocEntry() {
        return DocEntry;
    }

    public void setDocEntry(Integer DocEntry) {
        this.DocEntry = DocEntry;
    }

    public Integer getDocNum() {
        return DocNum;
    }

    public void setDocNum(Integer DocNum) {
        this.DocNum = DocNum;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    public String getWarehouse() {
        return Warehouse;
    }

    public void setWarehouse(String Warehouse) {
        this.Warehouse = Warehouse;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getCloseDate() {
        return CloseDate;
    }

    public void setCloseDate(Date CloseDate) {
        this.CloseDate = CloseDate;
    }

    public String getPlannedQty() {
        if (PlannedQty != null) {
            this.PlannedQty = String.format("%.4f", Double.valueOf(PlannedQty));
        }
        return PlannedQty;
    }

    public void setPlannedQty(String PlannedQty) {
        this.PlannedQty = PlannedQty;
    }

    public String getCmpltQty() {
        if (CmpltQty != null) {
            this.CmpltQty = String.format("%.4f", Double.valueOf(CmpltQty));
        }
        return CmpltQty;
    }

    public void setCmpltQty(String CmpltQty) {
        this.CmpltQty = CmpltQty;

    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public String toString() {
        return "OrdenFabricacion{" + "DocEntry=" + DocEntry + ", DocNum=" + DocNum + ", Status=" + Status + ", ItemCode=" + ItemCode + ", Warehouse=" + Warehouse + ", StartDate=" + StartDate + ", CloseDate=" + CloseDate + ", PlannedQty=" + PlannedQty + ", CmpltQty=" + CmpltQty + ", articulo=" + articulo + '}';
    }

}
