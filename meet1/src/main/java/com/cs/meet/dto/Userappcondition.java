package com.cs.meet.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Userappcondition {

    public String userName;

    public Integer userId;

    public BigInteger num;


    public Userappcondition(){

    }

    public Userappcondition(String userName,
                            Integer userId,
                            BigInteger num){
        this.userName = userName;
        this.userId = userId;
        this.num = num;
    }

}
