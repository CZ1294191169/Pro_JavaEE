package com.cs.meet.dto;

import com.cs.meet.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

@Data
public class UserMeetCondition {

    private String userName;

    private String roomName;

    private String theme;

    private String file;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Timestamp arrangementPeriodstart;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Timestamp arrangementPeriodend;

//    private String start;
//
//    private String end;

    public UserMeetCondition(){

    }
    public UserMeetCondition(String userName,
                             String roomName,
                             String theme,
                             String file,
                             Timestamp arrangementPeriodstart,
                             Timestamp arrangementPeriodend) throws ParseException {
       this.userName = userName;
       this.roomName=roomName;
       this.theme=theme;
       this.file=file;
       this.arrangementPeriodstart=arrangementPeriodstart;
       this.arrangementPeriodend=arrangementPeriodend;
//       this.start= DateUtil.Convertdatetoymdhm(this.startb);
//       this.end=DateUtil.Convertdatetoymdhm(this.endb);
    }


}
