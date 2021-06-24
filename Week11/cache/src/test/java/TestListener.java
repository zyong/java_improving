import io.kimmking.cache.CacheApplication;
import io.kimmking.cache.component.RedisPubSubListener;
import org.apache.tomcat.jni.Time;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CacheApplication.class)
public class TestListener {

    @Resource
    private JedisPool jedisPool;

    @Test
    public void testSub() {
        final RedisPubSubListener listener = new RedisPubSubListener();

        Jedis jedis = jedisPool.getResource();
        jedis.subscribe(listener, "channel");
        //可以订阅多个频道
//        jedis.subscribe(listener, "foo", "bar");

        //也用数组的方式设置多个频道
//        jedis.subscribe(listener, new String[]{"hello_foo","hello_test"});

        //使用模式匹配的方式设置频道
//        jedis.psubscribe(listener, new String[]{"hello_*"});
    }


}
