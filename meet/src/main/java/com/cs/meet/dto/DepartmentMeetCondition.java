package com.cs.meet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.text.ParseException;

@Data
public class DepartmentMeetCondition {

    private Integer departmentId;

    private String departmentName;

    private String userName;

    private String roomName;

    private String theme;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Timestamp arrangementPeriodstart;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Timestamp arrangementPeriodend;

    private Integer participate;

//    private String start;
//
//    private String end;

    public DepartmentMeetCondition(){

    }
    public DepartmentMeetCondition(
                            Integer departmentId,
                            String departmentName,
                            String userName,
                             String roomName,
                             String theme,
                             Timestamp arrangementPeriodstart,
                             Timestamp arrangementPeriodend,
                            Integer participate) throws ParseException {
        this.departmentId=departmentId;
        this.departmentName=departmentName;
        this.userName = userName;
        this.roomName=roomName;
        this.theme=theme;
        this.arrangementPeriodstart=arrangementPeriodstart;
        this.arrangementPeriodend=arrangementPeriodend;
        this.participate = participate;
//       this.start= DateUtil.Convertdatetoymdhm(this.startb);
//       this.end=DateUtil.Convertdatetoymdhm(this.endb);
    }

}
