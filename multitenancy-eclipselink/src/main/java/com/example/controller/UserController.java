package com.example.controller;

import com.example.entity.User;
import com.example.factory.UserFactory;
import com.example.factory.impl.UserFactoryImpl;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "/users", description = "Serviço REST de Usuários")
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserFactory userFactory;

    @ApiOperation(value = "Serviço para recuperar usuários", httpMethod = "GET", response = User.class)
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAll() {
        UserService userService = userFactory.getInstance();
        return userService.findAll();
    }

    @ApiOperation(value = "Serviço para criar usuário", httpMethod = "POST", response = User.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "Name", required = true)
    })
    @RequestMapping(method = RequestMethod.POST)
    public User save(@RequestBody String name)  {
        UserService userService = userFactory.getInstance();
        return userService.save(name);
    }

}
