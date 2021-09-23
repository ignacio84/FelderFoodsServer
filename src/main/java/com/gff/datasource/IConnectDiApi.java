
package com.gff.datasource;

import com.sap.smb.sbo.api.ICompany;

public interface IConnectDiApi {
    
    public ICompany openConection() throws Exception;
    
}
