package com.gff.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DiApiSourceImpl implements IDiApiSource {

    @Value("${diapi.serveraddress}")
    private String serverAddress;

    @Value("${diapi.databasename}")
    private String dataBaseName;

    @Value("${diapi.userdatabase}")
    private String userDataBase;

    @Value("${diapi.passwordsatabase}")
    private String passwordDataBase;

    @Value("${diapi.dbservertype}")
    private Integer dbServerType;

    @Value("${diapi.language}")
    private Integer language;

    @Value("${diapi.usersap}")
    private String userSap;

    @Value("${diapi.passwordsap}")
    private String passwordSap;

    @Value("${diapi.port}")
    private String portDiApi;

    @Override
    public String getServerAddress() {
        return this.serverAddress;
    }

    @Override
    public String getDataBaseName() {
        return this.dataBaseName;
    }

    @Override
    public String getUserDataBase() {
        return this.userDataBase;
    }

    @Override
    public String getPasswordDataBase() {
        return this.passwordDataBase;
    }

    @Override
    public Integer getDbServerType() {
        return this.dbServerType;
    }

    public Integer getLanguage() {
        return language;
    }

    @Override
    public String getUserSap() {
        return this.userSap;
    }

    @Override
    public String getPasswordSap() {
        return passwordSap;
    }

    @Override
    public String getPortDiApi() {
        return portDiApi;
    }

    @Override
    public String toString() {
        return "DiApiSourceImpl{" + "serverAddress=" + serverAddress + ", dataBaseName=" + dataBaseName + ", userDataBase=" + userDataBase + ", passwordDataBase=" + passwordDataBase + ", dbServerType=" + dbServerType + ", language=" + language + ", userSap=" + userSap + ", passwordSap=" + passwordSap + ", portDiApi=" + portDiApi + '}';
    }
}
