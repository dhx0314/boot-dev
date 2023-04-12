package cn.dhx;



import cn.dhx.boot.util.RestTemplateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {




    @Autowired
    private RestTemplateUtil restTemplateUtil;


    @Test
    public void getAndPost() {

        //get
//        restTemplateUtil.getForObject();
//        restTemplateUtil.getForObject1();
//        restTemplateUtil.getForObject2();

//        restTemplateUtil.getForEntity();


        //post
//        restTemplateUtil.postForObject();
//        restTemplateUtil.postForObjectFormData();
        restTemplateUtil.postForObjectFormDataFile();

    }



}
