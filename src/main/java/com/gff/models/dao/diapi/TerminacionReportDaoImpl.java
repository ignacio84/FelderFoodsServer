package com.gff.models.dao.diapi;

import com.gff.datasource.IConnectDiApi;
import com.sap.smb.sbo.api.ICompany;
import com.sap.smb.sbo.api.IRecordset;
import com.sap.smb.sbo.api.SBOCOMUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TerminacionReportDaoImpl implements ITerminacionReportDao {

    @Autowired
    private IConnectDiApi connectDiApi;

    @Override
    public void save() throws Exception {
        ICompany company = connectDiApi.openConection();
    }
    
    
    @Override
    public void findAll() throws Exception {
        
    }

//    @Override
//    public void findAll() throws Exception {
//        ICompany company = connectDiApi.openConection();
//        IRecordset recordSet;
//        int index;
//        if (company.isConnected()) {
//            recordSet = SBOCOMUtil.newRecordset(company);
//            recordSet.doQuery("SELECT * FROM OIGN WHERE DocNum=11556 ");
//            index = recordSet.getRecordCount();
//            // move to the first row
//            recordSet.moveFirst();
//            // iterate through all rows
//            for (int i = 0; i < index; i++)
//            {
//                System.out.println(recordSet.getFields().item(0).getName());
//                System.out.println(recordSet.getFields().item(0).getValue());
//                System.out.println("recordSet.getFields().getCount()"+recordSet.getFields().getCount());
//                // move to next row
//                recordSet.moveNext();
//            }             
//            recordSet.release();
//        }
//        if (company.isConnected()) {
//            System.out.println("Disconnected SAP DIAPI!");
//            company.disconnect();
//        }
//    }
}
