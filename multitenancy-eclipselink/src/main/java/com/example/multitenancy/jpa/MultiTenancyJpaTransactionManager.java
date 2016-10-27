package com.example.multitenancy.jpa;

import com.example.multitenancy.TenantHolder;
import org.eclipse.persistence.config.EntityManagerProperties;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;

public class MultiTenancyJpaTransactionManager extends JpaTransactionManager {

    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) {

        super.doBegin(transaction, definition);

        final EntityManagerHolder emHolder = (EntityManagerHolder) TransactionSynchronizationManager.getResource(getEntityManagerFactory());
        final EntityManager em = emHolder.getEntityManager();
        final String tenantId = TenantHolder.getTenant();

        if (tenantId != null) {
            em.setProperty(EntityManagerProperties.MULTITENANT_PROPERTY_DEFAULT, tenantId);
        }

    }
}
