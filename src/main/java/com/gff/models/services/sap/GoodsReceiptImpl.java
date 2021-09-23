
package com.gff.models.services.sap;

import com.gff.models.dao.diapi.ITerminacionReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GoodsReceiptImpl implements IGoodsReceiptService{
    
    @Autowired
    private ITerminacionReportDao dao;

    @Override
    public void save() throws Exception {
        this.dao.save();
    }

    @Override
    public void findAll() throws Exception {
        this.dao.findAll();
    }
}
