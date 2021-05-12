package com.mark3.service.Impl;

import com.mark3.entity.User;
import com.mark3.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mark3.service.UserService;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public String saveOne(User user) {
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setStatus(1);
        userMapper.insert(user);
        return "保存成功";
    }
}

