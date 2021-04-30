
package com.spring.app.models.entity.sqlserver;

import java.io.Serializable;
import java.util.Objects;

public class RolePermisoPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private String clave;

    private String role;

    public RolePermisoPK() {
    }

    public RolePermisoPK(String clave, String role) {
        this.clave = clave;
        this.role = role;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        final RolePermisoPK other = (RolePermisoPK) obj;
        if (!Objects.equals(this.clave, other.role)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return true;
    }
}