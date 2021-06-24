package io.kimmking.cache;

import io.kimmking.cache.component.RedisPubSubListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Subscriber {

    public static final String CHANNEL_NAME = "orderChannel";

    private static Logger logger = LoggerFactory.getLogger(Subscriber.class);

    public static void main(String[] args) throws Exception {
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        final JedisPool jedisPool = new JedisPool(poolConfig, "192.168.3.13", 6379, 0);
        final Jedis subscriberJedis = jedisPool.getResource();
        final RedisPubSubListener subscriber = new RedisPubSubListener();

        try {
            subscriberJedis.subscribe(subscriber, CHANNEL_NAME);
            logger.info("Subscription ended.");
        } catch (Exception e) {
            logger.error("Subscribing failed.", e);
        }
    }
}
