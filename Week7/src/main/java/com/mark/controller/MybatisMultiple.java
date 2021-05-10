package com.mark.controller;


import com.mark.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mark.service.UserService;

@RestController
public class MybatisMultiple {
    @Autowired
    private UserService userService;

    @RequestMapping("/insertuser")
    public int inserUser (String name, Integer age) {
        return userService.inserUser(name, age);
    }

    @RequestMapping("/selectuser")
    public User selectUser (String name) {
        return userService.selectUser(name);
    }
}
