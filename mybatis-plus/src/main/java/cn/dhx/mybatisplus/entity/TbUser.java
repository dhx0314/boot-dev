package cn.dhx.mybatisplus.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (TbUser)表实体类
 *
 * @author dhx
 * @since 2021-06-08 01:03:10
 */
@SuppressWarnings("serial")

@Accessors(chain = true)
@Data
@Getter
public class TbUser extends Model<TbUser> {
    //主键ID
    private Long id;
    //用户名
    private String userName;
    //密码
    private String password;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //邮箱
    private String email;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
