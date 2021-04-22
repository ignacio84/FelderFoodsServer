
package com.spring.app.models.entity.sqlserver;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private String clave;
    
    private String nombre;
    
    private String icono;
    
    private String clavePadre;

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

    @Override
    public String toString() {
        return "Menu{" + "clave=" + clave + ", nombre=" + nombre + ", icono=" + icono + ", clavePadre=" + clavePadre + '}';
    }
    
    
    
}
