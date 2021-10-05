package com.gff.models.dao.diapi;

import com.gff.datasource.IConnectDiApi;
import com.sap.smb.sbo.api.ICompany;
import com.sap.smb.sbo.api.IDocuments;
import com.sap.smb.sbo.api.IRecordset;
import com.sap.smb.sbo.api.SBOCOMConstants;
import com.sap.smb.sbo.api.SBOCOMUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodsReceiptDiapiDaoImpl implements IGoodsReceiptDiapiDao {

    @Autowired
    private IConnectDiApi connectDiApi;

    @Override
    public void save() throws Exception {
        ICompany company = connectDiApi.openConection();
        IDocuments oReceiptProduction;
        if (company.isConnected()) {
            try {
                oReceiptProduction = SBOCOMUtil.newDocuments(company, SBOCOMConstants.BoObjectTypes_Document_oInventoryGenEntry);//OBJETO DE TIPO RECIBO DE PRODUCCION (TERMINACION REPORT)
                oReceiptProduction.setComments("Comentarios recibo de produccion encabezado");//COMENTARIO

                oReceiptProduction.getLines().add();//AGREGA LINEA
                oReceiptProduction.getLines().setCurrentLine(0);
                oReceiptProduction.getLines().setBaseType(SBOCOMConstants.BoObjectTypes_oProductionOrders);//BASADO EN ORDEN DE FABRICACION
                oReceiptProduction.getLines().setBaseEntry(9262);//NUMERO DE ORDEN DE FABRICACION
                oReceiptProduction.getLines().setFreeText("Comentarios recibo de produccion linea");
//                    oReceiptProduction.getLines().setBaseLine(pcf.getLineNum());//BASADO EN LA LINEA 1 DEL PEDIDO DE COMPRA
//                    oReceiptProduction.getLines().setItemCode(pcf.getItemCode());//CODIGO DE ARTICULO AL QUE SE LE DARA ENTRADA
                oReceiptProduction.getLines().setQuantity(48.00);//CANTIDAD A LA QUE SE LE DARA ENTRADA
                //AGREGAN LOTES
                oReceiptProduction.getLines().getBatchNumbers().add();//AGREGA NUEVO LOSTE A LA LISTA DE SALIDA
                oReceiptProduction.getLines().getBatchNumbers().setBaseLineNumber(0);//detalle linea 1
                oReceiptProduction.getLines().getBatchNumbers().setBatchNumber("lote");
                oReceiptProduction.getLines().getBatchNumbers().setQuantity(48.00);

                if (oReceiptProduction.add() == 0) {
                    System.out.println("RECIBO DE PRODUCCION GENERADO CORRECTAMENTE");
                    IDocuments doc = SBOCOMUtil.getDocuments(company, SBOCOMConstants.BoObjectTypes_Document_oInventoryGenEntry, Integer.valueOf(company.getNewObjectKey()));
                    if (doc == null) {//SI NO ENCUENTRA DOCUMENTO 
                        throw new Exception(company.getLastErrorCode() + " - " + company.getLastErrorDescription());
                    }
                    System.out.println("doc.getDocNum()" + doc.getDocNum());
                } else {
                    System.out.println(company.getLastErrorCode() + " - " + company.getLastErrorDescription());
                    throw new Exception(company.getLastErrorCode() + " - " + company.getLastErrorDescription());
                }
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
                throw new Exception(e.getMessage());
            } finally {
                if (company.isConnected()) {
                    System.out.println("Disconnected SAP DIAPI! save");
                    company.disconnect();
                }
            }
        }
    }

    @Override
    public void findAll() throws Exception {
        ICompany company = connectDiApi.openConection();
        IRecordset recordSet;
        int index;
        if (company.isConnected()) {
            try {
                recordSet = SBOCOMUtil.newRecordset(company);
                recordSet.doQuery("SELECT * FROM OIGN WHERE DocNum=11556 ");
                index = recordSet.getRecordCount();
                // move to the first row
                recordSet.moveFirst();
                // iterate through all rows
                for (int i = 0; i < index; i++) {
                    System.out.println(recordSet.getFields().item(0).getName());
                    System.out.println(recordSet.getFields().item(0).getValue());
                    System.out.println("recordSet.getFields().getCount()" + recordSet.getFields().getCount());
                    // move to next row
                    recordSet.moveNext();
                }
                recordSet.release();
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
                throw new Exception(e.getMessage());
            } finally {
                if (company.isConnected()) {
                    System.out.println("Disconnected SAP DIAPI!");
                    company.disconnect();
                }
            }
        }
    }
}
