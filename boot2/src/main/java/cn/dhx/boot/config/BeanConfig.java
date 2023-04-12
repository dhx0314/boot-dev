package cn.dhx.boot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Author daihongxin
 * @create 2023/3/31 14:07
 */
@Configuration
public class BeanConfig {


    /**
     * RestTemplate 支持至少三种HTTP客户端库。
     * SimpleClientHttpRequestFactory。对应的HTTP库是java JDK自带的HttpURLConnection。
     * HttpComponentsAsyncClientHttpRequestFactory。对应的HTTP库是Apache HttpComponents。
     * OkHttp3ClientHttpRequestFactory。对应的HTTP库是OkHttp
     *
     * @param
     * @return
     */
//    @Bean
//    public RestTemplate restTemplate(){
//        RestTemplate restTemplate = new RestTemplate(new OkHttp3ClientHttpRequestFactory());
//        return restTemplate;
//    }


//    @Bean
//    public ClientHttpRequestFactory okHttp3ClientHttpRequestFactory(){
//        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory();
//        //设置请求超时时间是6秒
//        factory.setReadTimeout(6000);
//        //设置连接超时时间是6秒
//        factory.setConnectTimeout(6000);
//        return factory;
//    }
//
//    @Bean
//    public RestTemplate restTemplate(@Qualifier("okHttp3ClientHttpRequestFactory") ClientHttpRequestFactory factory){
//        //返回restTemplate的实例
//        return new RestTemplate(factory);
//    }
    @Bean
    public RestTemplate restTemplate() {

//        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();

        //返回restTemplate的实例
        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory();
        //设置请求超时时间是6秒
        factory.setReadTimeout(6000);
        //设置连接超时时间是6秒
        factory.setConnectTimeout(6000);

        return new RestTemplate(factory);
    }
}
