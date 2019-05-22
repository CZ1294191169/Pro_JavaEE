package com.cs.meet.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class Meeting_room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;//会议室编号

    private String roomName;//会议室名称

    private String roomIcon;//会议室缩略图

    private Date createTime;//创建时间

    private Date editTime;//修改时间


    @Override
    public String toString() {
        return JSONObject.toJSONString(this,true);
    }

}
