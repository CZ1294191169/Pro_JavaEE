package com.cs.meet.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Meetdistributecondition {

     public String name;

     public BigInteger num;

     public Meetdistributecondition(){

     }

     public Meetdistributecondition(String name,
                                    BigInteger num){
          this.name = name;
          this.num = num;
     }
}
