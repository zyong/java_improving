package com.mark.db2.service;

import com.mark.db1.mapper.UserMapper1;
import com.mark.db2.mapper.UserMapper2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService2 {
    private final Logger logger = LoggerFactory.getLogger(UserService2.class);
    @Autowired
    private UserMapper2 userMapper2;
    @Autowired
    private UserMapper1 userMapper1;

    public int inserUser(String name, Integer age) {
        int result = userMapper2.insert(name, age);
        int i = 1/ age;
        logger.info("insert user result " +  result);
        return result;
    }


    @Transactional(transactionManager = "db2TransactionManager")
    public int insertUser(String name, Integer age) {
        int insertUserResult = userMapper2.insert(name, age);
        int i = 1 / age;
        System.out.println(insertUserResult + "");
        return insertUserResult;
    }

    // 测试多事务回滚
    //因为@Transactional(transactionManager = "test2TransactionManager")所以说只会回滚第二个数据源，第一个数据源依然插入了
    @Transactional(transactionManager = "db2TransactionManager")
    public int insertUsertest01andtest02(String name, Integer age) {
        //传统分布式事务解决方案，jta+atomikos注册同一个全局事务中
        // 第一个数据源
        int insertUserResult01 = userMapper1.insert(name, age);
        // 第二个数据源
        int insertUserResult02 = userMapper2.insert(name, age);
        // 如果age等于0，看看这两个数据源哪一个会回滚
        int i = 1 / age;
        System.out.println(insertUserResult01 + "" + insertUserResult02);
        int insertUserResult = insertUserResult01 + insertUserResult02;
        return insertUserResult;
    }
}
