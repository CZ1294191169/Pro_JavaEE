package com.cs.meet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.sql.Timestamp;

@Data
public class UserFullmessagecondition {


    public String userName; //用户姓名

    public String empCode;//员工编码

    public Integer departmentId;//用户部门id

    public String departmentName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Timestamp jobJointime;//参加工作时间

    public String personDes;//个人描述

    public String personPhone;//个人电话

    public String personEmail;//个人邮箱


    public Integer userStatus; //用户身份标识

    public UserFullmessagecondition(){

    }

    public UserFullmessagecondition(String userName,
                                    String empCode,
                                    Integer departmentId,
                                    String departmentName,
                                    Timestamp jobJointime,
                                    String personDes,
                                    String personPhone,
                                    String personEmail,
                                    Integer userStatus){
        this.userName = userName;
        this.empCode = empCode;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.jobJointime = jobJointime;
        this.personDes = personDes;
        this.personEmail = personEmail;
        this.personPhone = personPhone;
        this.userStatus = userStatus;

    }






}
