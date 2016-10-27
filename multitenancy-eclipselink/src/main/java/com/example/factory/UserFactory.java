package com.example.factory;

import com.example.service.UserService;

public interface UserFactory {

    UserService getInstance();

}
