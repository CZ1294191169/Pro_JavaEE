package com.cs.meet.dto;


import lombok.Data;

@Data
public class Affstatuscondition {

    Integer affairsId;

    Integer affairsStatus;

    public Affstatuscondition(){

    }

    public Affstatuscondition(Integer affairsId,
                              Integer affairsStatus){
        this.affairsId = affairsId;
        this.affairsStatus = affairsStatus;
    }
}
