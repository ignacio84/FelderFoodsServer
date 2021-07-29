package com.gff.models.services.app;

import com.gff.models.dao.app.ICatalogoControlDao;
import com.gff.models.entity.app.CatalogoControl;
import com.gff.models.entity.app.Usuario;
import java.util.List;
import jdk.nashorn.internal.runtime.regexp.joni.constants.CCSTATE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("CatalogoControlServices")
public class CatalogoControlServiceImpl implements ICatalogoControlService {
    
    @Autowired
    private ICatalogoControlDao ccsDao;

    @Transactional(readOnly = true)
    public List<CatalogoControl> findAll() {
        return (List<CatalogoControl>) this.ccsDao.findAll();
    }

}
