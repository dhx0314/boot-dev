package cn.dhx;



import cn.dhx.boot.util.HttpdAndNginxFileUtil;
import cn.dhx.boot.util.RestTemplateFileUtil;
import cn.dhx.boot.util.RestTemplateUtil;
import cn.dhx.boot.util.RestTemplateUtilV2;
import cn.dhx.util.SambaUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyFileTest {




    @Autowired
    private SambaUtils sambaUtils;

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Autowired
    private RestTemplateFileUtil restTemplateFileUtil;

    @Autowired
    private HttpdAndNginxFileUtil httpdAndNginxFileUtil;

    @Autowired
    private RestTemplateUtilV2 restTemplateUtilV2;


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
//        restTemplateUtil.postForObjectFormDataFile();

//        restTemplateUtil.getBytesFromApi();
        restTemplateUtilV2.timeout();
    }


    @Test
    public void fileTest() {
//        restTemplateFileUtil.downLoad();
//        restTemplateFileUtil.upload();
        restTemplateFileUtil.upload2();
//        restTemplateFileUtil.testDownLoadBigFile();
    }

    @Test
    public void nginxFileTest() {
//        httpdAndNginxFileUtil.downLoadFile();
//        httpdAndNginxFileUtil.uploadFile();
    }


    @Test
    public void fun1() {
//        sambaUtils.down();
        sambaUtils.down2();

//        sambaUtils.upload2();
    }



}
