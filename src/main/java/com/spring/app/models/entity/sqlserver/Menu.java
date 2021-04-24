
package com.spring.app.models.entity.sqlserver;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private String clave;
    
    private String nombre;
    
    private String icono;
    
    private String clavePadre;
    
    @Transient
    private List<Menu> subMenu;

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

    public List<Menu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<Menu> subMenu) {
        this.subMenu = subMenu;
    }

    @Override
    public String toString() {
        return "Menu{" + "clave=" + clave + ", nombre=" + nombre + ", icono=" + icono + ", clavePadre=" + clavePadre + ", subMenu=" + subMenu + '}';
    }
    
}
