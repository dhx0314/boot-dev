package cn.dhx.jvm.object;

import cn.dhx.jvm.pojo.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/6/11 0:14
 */
@Slf4j
public class ObjectAllocation {

    public User user1() {
        User user = new User();
        user.setId(1);
        user.setName("zhangsang");
        // TO 保存到数据库
        return user;
    }

    public void user2() {
        User user = new User();
        user.setId(1);
        user.setName("zhangsang");
        // TO 保存到数据库
    }
}
