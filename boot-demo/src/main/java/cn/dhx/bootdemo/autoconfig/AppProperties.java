package cn.dhx.bootdemo.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ConfigurationProperties(prefix = "tsapi")
public class AppProperties {

    private List<AppProp> aesList;

//    private final AppProp app = new AppProp();


//    public static void main(String[] args) {
//        AppProperties appProperties = new AppProperties();
//        List<AppProp> data = appProperties.getData();
//        for (AppProp datum : data) {
//            System.out.println(datum);
//        }
//    }
}



