package com.gff.models.services.sap;

import com.gff.models.dao.sap.IProductionOrderDao;
import com.gff.models.entity.sap.ProductionOrder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductionOrderServiceImpl implements IProductionOrderService {

    @Autowired
    private IProductionOrderDao ofcDao;

    @Override
    public ProductionOrder findById(Integer id) {
        return this.ofcDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductionOrder> findAllOpen() {
        return this.ofcDao.findAllOpen();
    }

    @Override
    public List<ProductionOrder> findAll() {
        return (List<ProductionOrder>) this.ofcDao.findAll();
    }

}
