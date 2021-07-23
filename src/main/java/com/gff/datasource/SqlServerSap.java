package com.gff.datasource;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( entityManagerFactoryRef = "SqlServerSapEntityManager", 
                        transactionManagerRef = "SqlServerSapTransactionManager", 
                        basePackages = {"com.gff.models.dao.sap"})
public class SqlServerSap {

    @Autowired
    private Environment env;

    @Primary
    @Bean(name = "SqlServerSapDataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("sqlserver.sap.datasource.url"));
        dataSource.setUsername(env.getProperty("sqlserver.sap.datasource.username"));
        dataSource.setPassword(env.getProperty("sqlserver.sap.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("sqlserver.sap.datasource.driver-class-name"));
        return dataSource;
    }

    @Primary
    @Bean(name = "SqlServerSapEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySap() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.gff.models.entity.sap");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        Map<String, Object> propierties = new HashMap<>();
        propierties.put("hibernate.show-sql", env.getProperty("sqlserver.sap.jpa.show-sql"));
        propierties.put("hibernate.dialect", env.getProperty("sqlserver.sap.jpa.database-platform"));
        propierties.put("hibernate.hbm2ddl.auto", env.getProperty("sqlserver.sap.jpa.hibernate.ddl-auto"));
        em.setJpaPropertyMap(propierties);
        return em;
    }

    @Primary
    @Bean(name = "SqlServerSapTransactionManager")
    public PlatformTransactionManager transactionManagerSap() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactorySap().getObject());
        return transactionManager;
    }
}
