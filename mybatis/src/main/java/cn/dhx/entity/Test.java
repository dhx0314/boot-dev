package cn.dhx.entity;

import java.io.Serializable;

/**
 * (Test)实体类
 *
 * @author dhx
 * @since 2022-06-27 12:30:19
 */
public class Test implements Serializable {
    private static final long serialVersionUID = 537009704649528319L;
    
    private Integer id;
    
    private Integer info;
    
    private Boolean xx;


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



}

