package cn.dhx.mybatisplus.oracle.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (IpStation)表实体类
 *
 * @author makejava
 * @since 2021-06-08 17:53:21
 */
@SuppressWarnings("serial")
@TableName("ip_station")
public class IpStation2 extends Model<IpStation2> {

    @TableId(value = "sid",type = IdType.AUTO)
    private Integer sid;

    private String stationip;

    private String station;

    private String department;

    private String isrecord;

    private String stationtype;

    private String startstation;

    private String endstation;

    private Object timestamp;


    public String getStationip() {
        return stationip;
    }

    public void setStationip(String stationip) {
        this.stationip = stationip;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getIsrecord() {
        return isrecord;
    }

    public void setIsrecord(String isrecord) {
        this.isrecord = isrecord;
    }

    public String getStationtype() {
        return stationtype;
    }

    public void setStationtype(String stationtype) {
        this.stationtype = stationtype;
    }

    public String getStartstation() {
        return startstation;
    }

    public void setStartstation(String startstation) {
        this.startstation = startstation;
    }

    public String getEndstation() {
        return endstation;
    }

    public void setEndstation(String endstation) {
        this.endstation = endstation;
    }

    public Object getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Object timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.sid;
    }
}
