package com.cs.meet.entity;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Entity
@DynamicUpdate//动态更新
@Data
public class User_info implements Serializable {


    //指定简单视图
    public interface UserSimpleView {
    }

    ;

    //指定详细视图，要求要能将简单视图的能显示的字段也能显示出来
    public interface UserDetailView extends UserSimpleView {
    }

    ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;//用户id


    @NotEmpty(message = "用户名不能为空！")
    private String userName; //用户姓名

    private String userCode;//用户账号

    @NotBlank(message = "密码不能为空")//验证密码不为空
    @Size(min = 6, max = 10, message = "密码长度必须6到10位")
    private String loginPassword;//用户登录密码

    private String loginIcon;//用户头像icon

    private Integer departmentId;//用户部门id

    private Integer userStatus; //用户身份标识

    private String empCode;//员工编码

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp jobJointime;//参加工作时间

    private String personDes;//个人描述

    private String personEmail;//个人邮箱

    private String personPhone;//个人电话

    private String userSalt;//加密密码的盐

//    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
//    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })

    // private List<SysRole> roleList;// 一个用户具有多个角色

    private Date createTime;//创建时间

    private Date editTime;//修改时间


    @Override
    public String toString() {
        return JSONObject.toJSONString(this, true);
    }


    /**
     * 密码盐.
     *
     * @return
     */
    public String getCredentialsSalt() {
        return this.userName + this.userSalt;
    }

}
