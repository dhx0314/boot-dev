package cn.dhx.security.service;

import cn.dhx.security.entity.User;
import cn.dhx.security.pojo.ResponseResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/7/11 11:36
 */
public interface LoginService {

    public ResponseResult login(User user) ;

    public ResponseResult logout() ;
}
