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
@DynamicUpdate//动态更新
@Data
public class Cultivate_info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cultivateId;//培训课程编号

    private String cultivateName;//培训课程名称

    private Integer cultivatPeo;//培训班可容纳人数

    private Date createTime;//创建时间

    private Date editTime;//修改时间


    @Override
    public String toString() {
        return JSONObject.toJSONString(this,true);
    }

}
