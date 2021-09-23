
package com.gff.datasource;

import com.sap.smb.sbo.api.ICompany;
import com.sap.smb.sbo.api.SBOCOMUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConnectDiApiImpl implements IConnectDiApi {
    
    @Autowired
    private IDiApiSource source; 

    @Override
    public ICompany openConection() throws Exception {
        ICompany company = SBOCOMUtil.newCompany();
        company.setServer(source.getServerAddress());
        company.setCompanyDB(source.getDataBaseName());
        company.setUserName(this.source.getUserSap());
        company.setPassword(this.source.getPasswordSap());
//        company.setDbServerType(SBOCOMConstants.BoDataServerTypes_dst_MSSQL2016);
        company.setDbServerType(this.source.getDbServerType());
        company.setUseTrusted(new Boolean(false));
//        company.setLanguage(SBOCOMConstants.BoSuppLangs_ln_Spanish_La);
        company.setLanguage(this.source.getLanguage());
        company.setDbUserName(source.getUserDataBase());
        company.setDbPassword(source.getPasswordDataBase());
        company.setLicenseServer(source.getServerAddress() + ":" + source.getPortDiApi());
        company.connect();
        if (company.isConnected()) {
            System.out.println("Connected SAP DIAPI!");
        } else {
            throw new Exception(company.getLastError().getErrorCode() + " - " + company.getLastError().getErrorMessage());
        }
        return company;
    }
    
}
