package com.gff.models.entity.app;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "catalogo_control",
        uniqueConstraints
        = @UniqueConstraint(columnNames = {"nombre", "enabled"}))
public class CatalogoControl implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Boolean enabled;

    @Column(nullable = false)
    private Integer idUsrAdd;
    

    private Date addAt;

    private Date upadateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getIdUsrAdd() {
        return idUsrAdd;
    }

    public void setIdUsrAdd(Integer idUsrAdd) {
        this.idUsrAdd = idUsrAdd;
    }

    public Date getAddAt() {
        return addAt;
    }

    public void setAddAt(Date addAt) {
        this.addAt = addAt;
    }

    public Date getUpadateAt() {
        return upadateAt;
    }

    public void setUpadateAt(Date upadateAt) {
        this.upadateAt = upadateAt;
    }
}
