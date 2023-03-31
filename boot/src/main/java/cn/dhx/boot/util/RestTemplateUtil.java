package cn.dhx.boot.util;

/**
 * @Author daihongxin
 * @create 2023/3/31 13:46
 */
public class RestTemplateUtil {


    /**
     * RestTemplate是Spring提供的一个简化HTTP请求的工具类，可以发送HTTP请求并处理响应结果。
     * 使用RestTemplate发送HTTP请求，需要以下步骤：
     *
     * 1.创建RestTemplate实例
     * 可以使用无参构造函数创建RestTemplate实例，也可以使用RestTemplateBuilder构造器创建。
     * 2.设置请求头
     * 设置请求头可以使用RestTemplate提供的方法setHeader，也可以使用HttpHeaders类。
     * 3.设置请求参数
     * 设置请求参数可以使用RestTemplate提供的方法setVariable，也可以使用Map类型的参数。
     * 4.发送请求
     * 发送请求可以使用RestTemplate提供的方法getForObject、getForEntity、postForObject、postForEntity等。
     * 5.处理响应结果
     * 处理响应结果可以使用RestTemplate提供的方法getBody、getHeaders、getStatusCode等。
     *
     */
}
