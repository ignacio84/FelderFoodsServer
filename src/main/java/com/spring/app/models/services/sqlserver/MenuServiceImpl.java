
package com.spring.app.models.services.sqlserver;

import com.spring.app.models.dao.sqlserver.IMenuDao;
import com.spring.app.models.entity.sqlserver.Menu;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuServiceImpl implements IMenuService {
    
    
    @Autowired
    private IMenuDao menuDao;
    
    
    @Transactional(readOnly = true)
    @Override
    public List<Menu> getMenu(){
        return this.menuDao.findAll();
    }
}
