package com.cs.meet.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class AppUser implements Serializable {

    public String userName;

    public String userCode;

    public Integer roomId;

    public String theme;

    public Integer participate;

    public Integer userList[];

    public String file;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    public Timestamp arrangementPeriodstart;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    public Timestamp arrangementPeriodend;

    public AppUser(){

    }

    public AppUser(String userName,
                   String userCode,
                   Integer roomId,
                   String theme,
                   Integer participate,
                   String file,
                   Timestamp arrangementPeriodstart,
                   Timestamp arrangementPeriodend,
                   Integer userList[]){
        this.userName = userName;
        this.userCode = userCode;
        this.roomId = roomId;
        this.theme = theme;
        this.participate = participate;
        this.file = file;
        this.arrangementPeriodstart = arrangementPeriodstart;
        this.arrangementPeriodend = arrangementPeriodend;
        this.userList = userList;
    }
}
