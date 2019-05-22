package com.cs.meet.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@DynamicUpdate//动态更新
@Data
public class Department_table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;//部门编号

    private String departmentName;//部门名称

    @Email
    private String deapartmentEmail;//部门邮箱

    private String departmentPho;//部门联系方式

    private Date createTime;//创建时间

    private Date editTime;//修改时间


    @Override
    public String toString() {
        return JSONObject.toJSONString(this,true);
    }


}
