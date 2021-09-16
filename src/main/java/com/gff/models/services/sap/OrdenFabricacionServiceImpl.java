package com.gff.models.services.sap;

import com.gff.models.dao.sap.IOrdenFabricacionDao;
import com.gff.models.entity.sap.OrdenFabricacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdenFabricacionServiceImpl implements IOrdenFabricacionService {

    @Autowired
    private IOrdenFabricacionDao ofcDao;

    @Override
    public OrdenFabricacion findById(Integer id) {
        return this.ofcDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<OrdenFabricacion> findAllOpen() {
        return this.ofcDao.findAllOpen();
    }

    @Override
    public List<OrdenFabricacion> findAll() {
        return (List<OrdenFabricacion>) this.ofcDao.findAll();
    }

}
