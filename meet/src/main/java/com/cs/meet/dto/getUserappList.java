package com.cs.meet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class getUserappList {
    public Integer affairsId;

    public String userName;

    public Integer participate;

    public String roomName;

    public String file;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    public Timestamp arrangementPeriodstart;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    public Timestamp arrangementPeriodend;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    public Timestamp createTime;

    public Integer userStatus;

    public getUserappList(){

    }

    public getUserappList(Integer affairsId,
                            String userName,
                            Integer participate,
                            String roomName,
                            String file,
                            Timestamp arrangementPeriodstart,
                            Timestamp arrangementPeriodend,
                            Timestamp createTime,
                          Integer userStatus)
    {
        this.affairsId = affairsId;
        this.userName = userName;
        this.participate=participate;
        this.roomName=roomName;
        this.file=file;
        this.arrangementPeriodstart = arrangementPeriodstart;
        this.arrangementPeriodend = arrangementPeriodend;
        this.createTime = createTime;
        this.userStatus = userStatus;
    }
}
