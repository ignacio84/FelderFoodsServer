package com.spring.app.datasource;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableJpaRepositories(entityManagerFactoryRef = "SqlServerEntityManager", transactionManagerRef = "SqlServerTransactionManager", basePackages = {"com.spring.app.models.dao.sqlserver"})//PACKAGE DONDE SE ENCUENTRAN LAS CLASES DAO DE SQLSERVER
public class SqlServerApp {

    @Autowired
    private Environment env;
    
//    @Primary
    @Bean(name = "SqlServerDataSource")
    public DataSource sqlserverDataSource(){
        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("sqlserver.datasource.url"));
        dataSource.setUsername(env.getProperty("sqlserver.datasource.username"));
        dataSource.setPassword(env.getProperty("sqlserver.datasource.password"));  
        dataSource.setDriverClassName(env.getProperty("sqlserver.datasource.driver-class-name"));
        return dataSource;
    }
    
//    @Primary
    @Bean(name ="SqlServerEntityManager" )
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(sqlserverDataSource());
        em.setPackagesToScan("com.spring.app.models.entity.sqlserver");//PACKAGE DONDE SE ENCUENTRAN LAS CLASES ETITIES HIBERNATE DE SQLSERVER
        HibernateJpaVendorAdapter vendorAdapter=new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        Map<String,Object> propierties = new HashMap<>();
        propierties.put("hibernate.show-sql", env.getProperty("sqlserver.jpa.show-sql"));
        propierties.put("hibernate.format_sql", env.getProperty("sqlserver.hibernate.format_sql"));
        propierties.put("hibernate.dialect", env.getProperty("sqlserver.jpa.database-platform"));
        propierties.put("hibernate.hbm2ddl.auto", env.getProperty("sqlserver.jpa.hibernate.ddl-auto"));
        em.setJpaPropertyMap(propierties);
        return em;
    }
    
//    @Primary
    @Bean(name ="SqlServerTransactionManager")
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager= new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}

