package com.spring.app.models.services.sqlserver;

import com.spring.app.models.entity.sqlserver.Menu;
import java.util.List;

public interface IMenuService {

    public List<Menu> findMenu();

}
