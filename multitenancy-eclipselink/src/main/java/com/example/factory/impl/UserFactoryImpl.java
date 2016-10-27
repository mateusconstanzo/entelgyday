package com.example.factory.impl;

import com.example.factory.UserFactory;
import com.example.multitenancy.TenantHolder;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserFactoryImpl implements UserFactory {

    @Autowired
    private List<UserService> services;

    private static final Map<String, UserService> map = new HashMap<>();

    @PostConstruct
    public void init() {
        for (UserService service : services) {
            map.put(service.getTenant(), service);
        }
    }

    @Override
    public UserService getInstance() {

        final String tenantId = TenantHolder.getTenant();

        UserService service = map.get(tenantId);

        return service;
    }
}
