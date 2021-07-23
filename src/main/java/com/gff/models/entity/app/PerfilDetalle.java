package com.gff.models.entity.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "perfil_detalle",
        uniqueConstraints
        = @UniqueConstraint(columnNames = {"perfil_id", "catalogo_control_id", "enabled"}))
public class PerfilDetalle implements Serializable {

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

    @Column(length = 1)//N:no permitir, V:ver  S:si permitir todo
    private String permiso;

    @Column(nullable = false)
    private Integer idUsrAdd;

    private Date addAt;

    private Date upadateAt;

    @JsonIgnoreProperties({"perfilDetalle","perfil"})
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "perfil_id", nullable = false)//updatable = false
    private Perfil perfil;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "catalogo_control_id", nullable = false)
    private CatalogoControl catalogoControl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
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

    public CatalogoControl getCatalogoControl() {
        return catalogoControl;
    }

    public void setCatalogoControl(CatalogoControl catalogoControl) {
        this.catalogoControl = catalogoControl;
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
    @Override
    public String toString() {
        return "PerfilDetalle{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", enabled=" + enabled + ", permiso=" + permiso + ", idUsrAdd=" + idUsrAdd + ", addAt=" + addAt + ", upadateAt=" + upadateAt + ", catalogoControl=" + catalogoControl + '}';
    }
}
