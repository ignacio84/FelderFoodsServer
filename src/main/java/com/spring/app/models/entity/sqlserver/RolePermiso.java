package com.spring.app.models.entity.sqlserver;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "role_permiso")
@IdClass(RolePermisoPK.class)
public class RolePermiso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String clave;

    @Id
    private String role;

    private String nombre;

    private String icono;

    private String clavePadre;

    private String html;

    private Boolean menuFinal;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Transient
    private List<RolePermiso> subMenu;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getClavePadre() {
        return clavePadre;
    }

    public void setClavePadre(String clavePadre) {
        this.clavePadre = clavePadre;
    }

    public List<RolePermiso> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<RolePermiso> subMenu) {
        this.subMenu = subMenu;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Boolean getMenuFinal() {
        return menuFinal;
    }

    public void setMenuFinal(Boolean menuFinal) {
        this.menuFinal = menuFinal;
    }

    @Override
    public String toString() {
        return "RolePermiso{" + "clave=" + clave + ", role=" + role + ", nombre=" + nombre + ", icono=" + icono + ", clavePadre=" + clavePadre + ", html=" + html + ", menuFinal=" + menuFinal + '}';
    }

}
