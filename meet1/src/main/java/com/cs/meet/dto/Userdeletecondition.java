package com.cs.meet.dto;

import lombok.Data;

@Data
public class Userdeletecondition {

    public String userName;

    public Userdeletecondition(){

    }
    public Userdeletecondition(String userName){
        this.userName = userName;
    }
}
