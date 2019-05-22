package com.cs.meet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Affchangecondition {

    public Integer affairsId;

    public String userName;

    public Integer participate;

    public Integer roomId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    public Timestamp arrangementPeriodstart;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    public Timestamp arrangementPeriodend;

    public Affchangecondition(){

    }

    public Affchangecondition(Integer affairsId,
                              String userName,
                              Integer participate,
                              Integer roomId,
                              Timestamp arrangementPeriodstart,
                              Timestamp arrangementPeriodend){
        this.affairsId = affairsId;
        this.userName = userName;
        this.participate= participate;
        this.roomId = roomId;
        this.arrangementPeriodstart = arrangementPeriodstart;
        this.arrangementPeriodend = arrangementPeriodend;
    }

}
