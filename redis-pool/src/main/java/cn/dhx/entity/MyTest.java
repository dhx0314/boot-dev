package cn.dhx.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (MyTest)表实体类
 *
 * @author dhx
 * @since 2022-06-29 14:03:12
 */
@SuppressWarnings("serial")
public class MyTest extends Model<MyTest> {
    
    private Integer id;
    
    private Integer info;
    
    private integer xx;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public integer getXx() {
        return xx;
    }

    public void setXx(integer xx) {
        this.xx = xx;
    }

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

