package com.example.service.impl;

import com.example.dao.UserDAO;
import com.example.entity.User;
import com.example.multitenancy.TenantEnum;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Transactional
    public User save(String name) {
        return userDAO.save(new User(name));
    }

    @Override
    public String getTenant() {
        return TenantEnum.DEFAULT.getValue();
    }

}
