package com.cs.meet.entity;

import lombok.Data;

import java.util.Date;

@Data
public class File {

    private String name;
    private String path;
    private Date date;

    public File()
    {

    }

    public File(String path,
                Date date){
        this.path=path;
        this.date=date;
    }

    public File(String name,
                String path,
                Date date){
        this.name=name;
        this.path=path;
        this.date=date;
    }
}
