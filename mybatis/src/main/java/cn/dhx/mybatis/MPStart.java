package cn.dhx.mybatis;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @Author daihongxin
 * @create 2023/3/9 20:29
 */
public class MPStart {

    public static void main(String[] args) {

        String url="jdbc:mysql://121.5.218.105:10001/my_db?autoReconnect=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false";
        String username="root";
        String password="dhx@root";


//        C:\D\gitee\boot-dev\mybatis\src\main\java\cn\dhx\mybatis

//        C:\D\gitee\boot-dev\mybatis\src\main\resources\mapper
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("dhx") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("C:\\D\\gitee\\boot-dev\\mybatis\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("cn.dhx.mybatis") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "C:\\D\\gitee\\boot-dev\\mybatis\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
               .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
