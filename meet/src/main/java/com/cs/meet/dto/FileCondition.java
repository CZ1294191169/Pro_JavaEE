package com.cs.meet.dto;

import com.cs.meet.entity.File;

import java.util.Date;

public class FileCondition {

    private int code;

    private String msg;

    private File data;


    public FileCondition()
    {

    }

    public FileCondition(int code,
                         String msg,
                         File data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }


}
