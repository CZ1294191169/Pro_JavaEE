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
public class Meet_category {

    @Id
    private Integer categoryId;//会议室类型编号

    private Integer roomId;//会议室编号

    private String categoryName;//会议室类型名称

    private Date createTime;//创建时间

    private Date editTime;//修改时间


    @Override
    public String toString() {
        return JSONObject.toJSONString(this,true);
    }

}
