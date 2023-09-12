package cn.dhx.boot.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author daihongxin
 * @create 2023/9/11 17:58
 */
@Slf4j
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {


    // 将自定义的拦截器注入
    @Autowired
    private TestInterceptor interceptor;

    /**
     * @param registry 注册对象
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册对象将拦截器添加进框架中
        registry.addInterceptor(interceptor)
                // 配置拦截规则
                .addPathPatterns("/**") // 拦截所有的 url
                .excludePathPatterns("/user/reg") // 排除用户注册 url
                .excludePathPatterns("/user/login") // 排除用户登陆 url
                .excludePathPatterns("/image/**"); // 排除 image 文件夹底下的所有文件
    }
}
