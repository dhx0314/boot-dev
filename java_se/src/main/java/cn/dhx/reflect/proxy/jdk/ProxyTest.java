package cn.dhx.reflect.proxy.jdk;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/9/1 9:47
 */
@Slf4j
public class ProxyTest {

    public static void main(String[] args) {
        UserService proxy = ProxyUtil.createProxy(new UserServiceImpl());
        proxy.addUser("zhangsan");
        ProxyUtil.generateClassFile(UserServiceImpl.class, "UserServiceProxy");

    }
}
