package com.gff.models.services.sap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gff.models.dao.diapi.IGoodsReceiptDiapiDao;
import com.gff.models.dao.sap.IGoodsReceiptSapDao;
import com.gff.models.entity.sap.GoodsReceipt;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsReceiptImpl implements IGoodsReceiptService {

    @Autowired
    private IGoodsReceiptDiapiDao diapiDao;

    @Autowired
    private IGoodsReceiptSapDao sapDao;

    @Override
    public void save() throws Exception {
//        this.diapiDao.save();
    }

//    @Override
//    public void findAll() throws Exception {
//        this.diapiDao.findAll();
//    }
    @Transactional(readOnly = true)
    @Override
    public List<GoodsReceipt> findAll() {
        return (List<GoodsReceipt>) this.sapDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public GoodsReceipt findByDocNum(Integer docNum) {
        return null;
    }
}
