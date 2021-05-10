package com.mark2;

import com.mark2.entity.SysUser;
import com.mark2.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicCurDataSourceApplicationTests {

    @Autowired
    private SysUserService userService;

    @Test
    public void contextLoads() {
        SysUser user = userService.getById(1);
        log.info(user.toString());
    }

    @Test
    public void test() throws NoSuchAlgorithmException {
        SysUser user = new SysUser();
        user.setUserId((long)2);
        user.setEmail("zzz@163.com");
        user.setMobile("1345683322");
        user.setSalt("sssa");
        user.setUsername("sad");
        MessageDigest md5 = MessageDigest.getInstance("SHA-256");
        md5.update("123456".getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : md5.digest()) {
            sb.append(String.format("%02x", b)); // 10进制转16进制，X 表示以十六进制形式输出，02 表示不足两位前面补0输出
        }
        user.setPassword(sb.toString());

        int num = userService.InsertUser(user);
        log.info("第一个数据库 : [insert user {} password {}]", num, user.getPassword());
        userService.deleteUser(user.getUsername());

        SysUser user2 = userService.findUser(1);
        log.info("第二个数据库 : [{}]", user2.toString());


    }
}
