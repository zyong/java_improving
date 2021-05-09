package com.mark.db1.service;

import com.mark.db1.mapper.UserMapper1;
import com.mark.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService1 {
    private final Logger logger = LoggerFactory.getLogger(UserService1.class);

    @Autowired
    private UserMapper1 userMapper1;

    @Transactional(transactionManager = "db1TransactionManager")
    public int inserUser(String name, Integer age) {
        int result = userMapper1.insert(name, age);
        logger.info("insert user result " +  result);
        return result;
    }
}
