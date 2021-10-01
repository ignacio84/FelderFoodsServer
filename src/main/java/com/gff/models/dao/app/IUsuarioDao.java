package com.gff.models.dao.app;

import com.gff.models.entity.app.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {

    public Usuario findByUsername(String username);

    @Query("   select u "
            + " from Usuario u   "
            + " inner join fetch u.perfil as p"
            + " inner join fetch p.perfilDetalle as pd"
            + " inner join fetch pd.catalogoControl as ct"
            + " where u.username=?1  "
            + " and u.enabled=true "
            + " and p.enabled=true "
            + " and pd.enabled=true "
            + " and pd.permiso!='N' "
            + " and ct.enabled=true"  )
    public Usuario findByUsername2(String username);

}
