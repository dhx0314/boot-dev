package cn.dhx.security.service.impl;

import cn.dhx.security.dao.UserMapper;
import cn.dhx.security.entity.User;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author daihongxin
 * @create 2023/7/11 11:19
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = new LambdaQueryChainWrapper<>(userMapper)
                .eq(User::getUserName, username).one();
        if (user == null) {
            throw new RuntimeException("用户名或者密码错误222");
        }

        log.info("user {}",user.toString());
        return new LoginUser(user);
    }
}
