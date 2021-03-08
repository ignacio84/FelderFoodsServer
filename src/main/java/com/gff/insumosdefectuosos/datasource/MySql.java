package com.gff.insumosdefectuosos.datasource;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "MySQLEntityManager", transactionManagerRef = "MySQLTransactionManager", basePackages = {"com.gff.insumosdefectuosos.models.dao.mysql"})//PACKAGE DONDE SE ENCUENTRAN LAS CLASES DAO DE MYSQL
public class MySql {
    
    @Autowired
    private Environment env;

    @Primary
    @Bean(name = "MySQlDataSource")
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("mysql.datasource.url"));
        dataSource.setUsername(env.getProperty("mysql.datasource.username"));
        dataSource.setPassword(env.getProperty("mysql.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("mysql.datasource.driver-class-name"));
        return dataSource;
    }

    @Primary
    @Bean(name = "MySQLEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(mysqlDataSource());
        em.setPackagesToScan("com.gff.insumosdefectuosos.models.entity.mysql");//PACKAGE DONDE SE ENCUENTRAN LAS CLASES ETITIES HIBERNATE DE MYSQL
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        Map<String, Object> propierties = new HashMap<>();
        propierties.put("hibernate.show_sql", env.getProperty("mysql.jpa.show-sql"));
        propierties.put("hibernate.format_sql", env.getProperty("mysql.hibernate.format_sql"));
        propierties.put("hibernate.dialect", env.getProperty("mysql.jpa.database-platform"));
        propierties.put("hibernate.hbm2ddl.auto", env.getProperty("mysql.jpa.hibernate.ddl-auto"));
//        propierties.put("spring.datasource.initialization-mode", "always");
//        propierties.put("spring.datasource.data", "classpath:insert.sql");
        em.setJpaPropertyMap(propierties);
        return em;
    }

    @Primary
    @Bean(name = "MySQLTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public DataSourceInitializer securityDataSourceInitializer() {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(this.mysqlDataSource());
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
//           databasePopulator.addScript(new ClassPathResource("data-mysql.sql"));
        databasePopulator.addScript(new ClassPathResource(env.getProperty("mysql.datasource.import_file")));
        dataSourceInitializer.setDatabasePopulator(databasePopulator);
        dataSourceInitializer.setEnabled(env.getProperty("mysql.datasource.initialize", Boolean.class, false));
        return dataSourceInitializer;
    }
}
