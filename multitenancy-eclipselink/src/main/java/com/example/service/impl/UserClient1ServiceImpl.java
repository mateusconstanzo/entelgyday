package com.example.service.impl;

import com.example.entity.User;
import com.example.multitenancy.TenantEnum;
import com.example.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserClient1ServiceImpl extends UserServiceImpl implements UserService {

    @Transactional
    public User save(String name) {
        return userDAO.save(new User(name));
    }

    @Override
    public String getTenant() {
        return TenantEnum.CLIENTE1.getValue();
    }

}
