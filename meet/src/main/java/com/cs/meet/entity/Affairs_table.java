package com.cs.meet.entity;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@DynamicUpdate//动态更新
@Data
public class Affairs_table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer affairsId;//事务编号

    private Integer userId;//用户编号

    private Integer roomId;//会议室编号

    private String theme;//会议主题

    private String file;//会议文件

    private Integer participate;//参会人数

    private Integer affairsStatus;//事务状态

    private Date arrangementPeriodstart;//会议安排开始时间

    private Date arrangementPeriodend;//会议安排结束时间

    private Date createTime;//创建时间

    private Date editTime;//修改时间



    @Override
    public String toString() {
        return JSONObject.toJSONString(this,true);
    }


}
