package io.kimmking.cache.controller;

import com.alibaba.fastjson.JSONObject;
import io.kimmking.cache.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    public static final String CHANNEL_NAME = "orderChannel";

    AtomicInteger orderId = new AtomicInteger(1);


    @Resource
    private JedisPool jedisPool;

    @RequestMapping("/puborder")
    public String pubOrder() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Order order = new Order();
            order.setOrderId(orderId.getAndIncrement());
            DecimalFormat df = new DecimalFormat( "0.00" );
            String str = df.format(genDouble());
            order.setAmount(Double.parseDouble(str));
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(order);
            String msg = String.valueOf(jsonObject);
            jedis.publish(CHANNEL_NAME, msg);
            logger.info(msg);
            return msg;
        } finally {
            if (jedis != null) {
                jedis.close();
            }

        }

    }

    private double genDouble() {
        Random random = new Random();
        double d;
        while (true) {
            d = random.nextFloat() * 100;
            if (d < 1) {
                continue;
            }
            break;
        }
        return d;
    }
}