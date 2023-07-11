package cn.dhx.security.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author daihongxin
 * @create 2023/7/11 10:52
 */


/**
 CREATE TABLE `sys_user` (
 `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
 `user_name` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '用户名',
 `nick_name` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '昵称',
 `password` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '密码',
 `status` CHAR(1) DEFAULT '0' COMMENT '账号状态（0正常 1停用）',
 `email` VARCHAR(64) DEFAULT NULL COMMENT '邮箱',
 `phonenumber` VARCHAR(32) DEFAULT NULL COMMENT '手机号',
 `sex` CHAR(1) DEFAULT NULL COMMENT '用户性别（0男，1女，2未知）',
 `avatar` VARCHAR(128) DEFAULT NULL COMMENT '头像',
 `user_type` CHAR(1) NOT NULL DEFAULT '1' COMMENT '用户类型（0管理员，1普通用户）',
 `create_by` BIGINT(20) DEFAULT NULL COMMENT '创建人的用户id',
 `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
 `update_by` BIGINT(20) DEFAULT NULL COMMENT '更新人',
 `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
 `del_flag` INT(11) DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
 PRIMARY KEY (`id`)
 ) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户表'
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user")
public class User implements Serializable {
    private static final long serialVersionUID = -40356785423868312L;

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 密码
     */
    private String password;
    /**
     * 账号状态（0正常 1停用）
     */
    private String status;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phonenumber;
    /**
     * 用户性别（0男，1女，2未知）
     */
    private String sex;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 用户类型（0管理员，1普通用户）
     */
    private String userType;
    /**
     * 创建人的用户id
     */
    private Long createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private Long updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    private Integer delFlag;
}


