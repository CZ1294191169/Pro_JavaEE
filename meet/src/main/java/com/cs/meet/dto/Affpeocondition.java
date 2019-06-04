package com.cs.meet.dto;


import lombok.Data;

@Data
public class Affpeocondition {

    public Integer userId;

    public String userName;

    public Affpeocondition(){

    }
    public Affpeocondition(Integer userId,
                           String userName){
        this.userId = userId;
        this.userName = userName;
    }
}
