package com.example.config;

import com.example.multitenancy.jpa.MultiTenancyJpaTransactionManager;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(value = "com.example.dao")
public class JpaConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);

        EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);

        factory.setJpaVendorAdapter(adapter);
        factory.setPackagesToScan("com.example");
        factory.getJpaPropertyMap().put(PersistenceUnitProperties.DDL_GENERATION_MODE, PersistenceUnitProperties.DDL_DATABASE_GENERATION);
        factory.getJpaPropertyMap().put(PersistenceUnitProperties.LOGGING_LEVEL, "FINE");
        factory.getJpaPropertyMap().put(PersistenceUnitProperties.WEAVING, "false");
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new MultiTenancyJpaTransactionManager();
        return transactionManager;
    }
}
