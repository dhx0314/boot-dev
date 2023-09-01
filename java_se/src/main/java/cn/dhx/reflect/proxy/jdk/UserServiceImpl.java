package cn.dhx.reflect.proxy.jdk;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/9/1 9:41
 */
@Slf4j
public class UserServiceImpl implements UserService{
    @Override
    public void addUser(String username) {

        log.info("add user running");

    }

    @Override
    public int delUser(String id) {
        log.info("del");
        return 1;
    }
}
