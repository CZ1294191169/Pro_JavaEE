package com.cs.meet.dto;


import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Calendercondition {

    public String title;

    public Timestamp start;

    public Timestamp end;

    public Calendercondition(){

    }

    public Calendercondition(String title,
                             Timestamp start,
                             Timestamp end){
        this.title = title;
        this.start = start;
        this.end   = end;
    }
}
