package com.cs.meet.dto;


import lombok.Data;

import java.util.Date;

@Data
public class Calfinalcondition {

    public String title;

    public Date start;

    public Date end;

    public Calfinalcondition(){

    }

    public Calfinalcondition(String title,
                             Date start,
                             Date end){
        this.title =  title;
        this.start = start;
        this.end = end;
    }
}
