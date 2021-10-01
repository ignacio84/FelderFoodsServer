
package com.gff.models.services.sap;

import com.gff.models.entity.sap.GoodsReceipt;
import java.util.List;


public interface IGoodsReceiptService {

    public void save() throws Exception ;
    
    public List<GoodsReceipt> findAll();
    
    public GoodsReceipt findByDocNum(Integer docNum);
}
