package com.cs.meet.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class affaircondition {

    private  String title;

    private Timestamp start;

    private Timestamp end;

    public affaircondition(){

    }
}
