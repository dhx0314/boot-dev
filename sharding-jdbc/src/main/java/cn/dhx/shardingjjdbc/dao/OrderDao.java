package cn.dhx.shardingjjdbc.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface OrderDao {


    @Insert("insert INTO t_order(price,user_id, status_) value(#{price},#{userId},#{status})")
    int insert(@Param("price") BigDecimal price, @Param("userId") Long userId, @Param("status") String status);
}
