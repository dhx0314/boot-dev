package cn.dhx.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2023-09-08 15:40:11
 */
@SuppressWarnings("serial")
@Data
@TableName("t_user")
public class User extends Model<User> {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userName;

    private Integer age;

    private String phone;

    private String email;

    public User(Integer id, String userName, Integer age, String phone, String email) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public User() {
    }
}

