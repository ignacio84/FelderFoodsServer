
package com.gff.insumosdefectuosos.models.entity.mysql;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entrada_merc_report")
public class ResumenProduccionDiario implements Serializable {
    
        private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enc_merc")
    private Integer id;
    
    @Column(name = "enc_merc_fec")
    private String fechaResumen;
    
    @Column(name = "enc_merc_fecmov")
    private Date fechaMovimiento;
    
    @Column(name = "enc_merc_noment")
    private String responsableEmpaque;  
    
    @Column(name = "en_merc_nomrec")
    private String responsableAlmacen;
    
    @Column(name = "entrada_merc_vtfil")
    private String cantidadVitafil;
    
    @Column(name = "entrada_merc_plazul")
    private String catidadPlasticoAzul;
    
    @Column(name = "cajoprE10061")
    private String cantidadDanadaE10061;
    
    @Column(name = "cajoprE10067")
    private String cantidadDanadaE10067;
    
    @Column(name = "cajoprE10089")
    private String cantidadDanadaE10089;
    
    @Column(name = "cajoprE10083")
    private String cantidadDanadaE10083;
    
    @Column(name = "cajprobE10061")
    private String cantidadDefectoE10061;
    
    @Column(name = "cajprobE10067")
    private String cantidadDefectoE10067;
    
    @Column(name = "cajprobE10089")
    private String cantidadDefectoE10089;
    
    @Column(name = "cajprobE10083")
    private String cantidadDefectoE10083;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaResumen() {
        return fechaResumen;
    }

    public void setFechaResumen(String fechaResumen) {
        this.fechaResumen = fechaResumen;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getResponsableEmpaque() {
        return responsableEmpaque;
    }

    public void setResponsableEmpaque(String responsableEmpaque) {
        this.responsableEmpaque = responsableEmpaque;
    }

    public String getResponsableAlmacen() {
        return responsableAlmacen;
    }

    public void setResponsableAlmacen(String responsableAlmacen) {
        this.responsableAlmacen = responsableAlmacen;
    }

    public String getCantidadVitafil() {
        return cantidadVitafil;
    }

    public void setCantidadVitafil(String cantidadVitafil) {
        this.cantidadVitafil = cantidadVitafil;
    }

    public String getCatidadPlasticoAzul() {
        return catidadPlasticoAzul;
    }

    public void setCatidadPlasticoAzul(String catidadPlasticoAzul) {
        this.catidadPlasticoAzul = catidadPlasticoAzul;
    }

    public String getCantidadDanadaE10061() {
        return cantidadDanadaE10061;
    }

    public void setCantidadDanadaE10061(String cantidadDanadaE10061) {
        this.cantidadDanadaE10061 = cantidadDanadaE10061;
    }

    public String getCantidadDanadaE10067() {
        return cantidadDanadaE10067;
    }

    public void setCantidadDanadaE10067(String cantidadDanadaE10067) {
        this.cantidadDanadaE10067 = cantidadDanadaE10067;
    }

    public String getCantidadDanadaE10089() {
        return cantidadDanadaE10089;
    }

    public void setCantidadDanadaE10089(String cantidadDanadaE10089) {
        this.cantidadDanadaE10089 = cantidadDanadaE10089;
    }

    public String getCantidadDanadaE10083() {
        return cantidadDanadaE10083;
    }

    public void setCantidadDanadaE10083(String cantidadDanadaE10083) {
        this.cantidadDanadaE10083 = cantidadDanadaE10083;
    }

    public String getCantidadDefectoE10061() {
        return cantidadDefectoE10061;
    }

    public void setCantidadDefectoE10061(String cantidadDefectoE10061) {
        this.cantidadDefectoE10061 = cantidadDefectoE10061;
    }

    public String getCantidadDefectoE10067() {
        return cantidadDefectoE10067;
    }

    public void setCantidadDefectoE10067(String cantidadDefectoE10067) {
        this.cantidadDefectoE10067 = cantidadDefectoE10067;
    }

    public String getCantidadDefectoE10089() {
        return cantidadDefectoE10089;
    }

    public void setCantidadDefectoE10089(String cantidadDefectoE10089) {
        this.cantidadDefectoE10089 = cantidadDefectoE10089;
    }

    public String getCantidadDefectoE10083() {
        return cantidadDefectoE10083;
    }

    public void setCantidadDefectoE10083(String cantidadDefectoE10083) {
        this.cantidadDefectoE10083 = cantidadDefectoE10083;
    }

    @Override
    public String toString() {
        return "ResumenProduccionDiario{" + "id=" + id + ", fechaResumen=" + fechaResumen + ", fechaMovimiento=" + fechaMovimiento + ", responsableEmpaque=" + responsableEmpaque + ", responsableAlmacen=" + responsableAlmacen + ", cantidadVitafil=" + cantidadVitafil + ", catidadPlasticoAzul=" + catidadPlasticoAzul + ", cantidadDanadaE10061=" + cantidadDanadaE10061 + ", cantidadDanadaE10067=" + cantidadDanadaE10067 + ", cantidadDanadaE10089=" + cantidadDanadaE10089 + ", cantidadDanadaE10083=" + cantidadDanadaE10083 + ", cantidadDefectoE10061=" + cantidadDefectoE10061 + ", cantidadDefectoE10067=" + cantidadDefectoE10067 + ", cantidadDefectoE10089=" + cantidadDefectoE10089 + ", cantidadDefectoE10083=" + cantidadDefectoE10083 + '}';
    }

 
}
