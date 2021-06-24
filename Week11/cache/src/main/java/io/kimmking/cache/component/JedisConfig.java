package io.kimmking.cache.component;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {

    private static final Logger log = LoggerFactory.getLogger(JedisConfig.class);

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port:6379}")
    private int port;

    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxTotal;

    @Value("${spring.redis.jedis.pool.max-idle:8}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.min-idle:0}")
    private int minIdle;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout:0}")
    private int timeout;

    @Bean
    public JedisPool redisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, null);
        log.info("JedisPool注入成功！！");
        log.info("redis地址：" + host + ":" + port);
        return jedisPool;
    }

    @Bean
    public Jedis jedis(){
        return new Jedis(host, port);
    }
}