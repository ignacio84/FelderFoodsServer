package com.gff.models.dao.sap;

import com.gff.models.entity.sap.GoodsReceipt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IGoodsReceiptSapDao extends CrudRepository<GoodsReceipt, Integer> {

    @Query("SELECT g from GoodsReceipt g where g.docNum=?1 ")
    public GoodsReceipt findByDocNum(Integer docNum);

}
