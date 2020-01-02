import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import wzy.graduate.project.anfaoc.api.redis.RedisHelper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunConfig.class)
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @MockBean
    private RedisHelper redisHelper;

    @Test
    public void test(){
        int a;
        a = 2;
        System.out.println(redisHelper);
        redisHelper.valuePut("abc",a);
        redisHelper.getValue("abc");
        System.out.println(redisHelper.getValue("abc"));
        System.out.println(redisHelper.getValue("key"));
    }

    @Test
    public void testObj () throws Exception{
        ValueOperations<String,Object> operations = redisTemplate.opsForValue();
        operations.set("abc","abc");
        Thread.sleep(500);
        System.out.println(redisTemplate.opsForValue().get("abc"));
    }

    @GetMapping("/submitCache")
    public void submitCacheTest() throws InterruptedException {
        redisHelper.valuePut("abc","123");
        Thread.sleep(500);
    }

    @GetMapping("/getCache")
    public String getCacheTest(){
        String abc = (String) redisHelper.getValue("abc");
        return abc;
    }
}
