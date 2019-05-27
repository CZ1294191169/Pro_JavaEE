package com.cs.meet.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Chartroomidcondition {

    public String roomName;

    public Integer roomId;

    public BigInteger roomNum;

    public Chartroomidcondition(){

    }
    public Chartroomidcondition(String roomName,
                                Integer roomId,
                                BigInteger roomNum){
        this.roomName = roomName;
        this.roomId = roomId;
        this.roomNum = roomNum;
    }


}
