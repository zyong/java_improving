package com.mark3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mark3.entity.User;
import com.mark3.service.UserService;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Description: 保存用户
     */
    @GetMapping("save-user")
    public Object saveUser() {
        return userService.saveOne(new User("小小", "女", 3));
    }

    /**
     * @Description: 获取用户列表
     */
    @GetMapping("list-user")
    public Object listUser() {
        return userService.list();
    }

}