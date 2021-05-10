package com.mark.service;

import com.mark.db1.mapper.UserMapper1;
import com.mark.db2.mapper.UserMapper2;
import com.mark.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper1 userMapper1;

    @Autowired
    private UserMapper2 userMapper2;

    public int inserUser(String name, Integer age) {
        int result = userMapper1.insert(name, age);
        logger.info("insert user result " +  result);
        return result;
    }


    @Transactional(transactionManager = "db1TransactionManager")
    public int insertUser(String name, Integer age) {
        int insertUserResult = userMapper1.insert(name, age);
        System.out.println(insertUserResult + "");
        return insertUserResult;
    }

    public User selectUser(String name) {
        return userMapper2.findByName(name);
    }
}
