package com.gff.models.entity.app;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario",
        uniqueConstraints
        = @UniqueConstraint(columnNames = {"username", "enabled", "email"}))
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false, unique = true)
    private String username;

    @Column(length = 250, nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean enabled;

    @Column(nullable = false)
    private String nombre;

    private String apellido;

    @Column(nullable = false)
    private String email;

    private Integer idUsrAdd;

    private Date addAt;

    private Date upadateAt;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Perfil perfil;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAddAt() {
        return addAt;
    }

    public void setAddAt(Date addAt) {
        this.addAt = addAt;
    }

    public Integer getIdUsrAdd() {
        return idUsrAdd;
    }

    public void setIdUsrAdd(Integer idUsrAdd) {
        this.idUsrAdd = idUsrAdd;
    }

    public Date getUpadateAt() {
        return upadateAt;
    }

    public void setUpadateAt(Date upadateAt) {
        this.upadateAt = upadateAt;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", idUsrAdd=" + idUsrAdd + ", addAt=" + addAt + ", upadateAt=" + upadateAt + ", perfil=" + perfil + '}';
    }
}
