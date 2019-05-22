package com.cs.meet.dto;

import lombok.Data;

@Data
public class Meetroomcondition {

    public Integer roomId;

    public String roomName;

    public Meetroomcondition(){

    }

    public Meetroomcondition(Integer roomId,
                             String roomName){
        this.roomId = roomId;
        this.roomName = roomName;
    }
}
