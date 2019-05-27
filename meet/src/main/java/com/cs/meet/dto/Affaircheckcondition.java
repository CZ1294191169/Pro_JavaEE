package com.cs.meet.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Affaircheckcondition {

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

    public Affaircheckcondition(){

    }

    public Affaircheckcondition(Integer affairsId,
                                String userName,
                                Integer participate,
                                String roomName,
                                String file,
                                Timestamp arrangementPeriodstart,
                                Timestamp arrangementPeriodend,
                                Timestamp createTime)
    {
        this.affairsId = affairsId;
        this.userName = userName;
        this.participate=participate;
        this.roomName=roomName;
        this.file=file;
        this.arrangementPeriodstart = arrangementPeriodstart;
        this.arrangementPeriodend = arrangementPeriodend;
        this.createTime = createTime;
    }
}
