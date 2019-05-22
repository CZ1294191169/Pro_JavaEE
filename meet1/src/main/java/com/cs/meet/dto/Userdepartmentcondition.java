package com.cs.meet.dto;

import lombok.Data;

@Data
public class Userdepartmentcondition {

    public Integer departmentId;

    public String departmentName;

    public Userdepartmentcondition(){

    }

    public Userdepartmentcondition(Integer departmentId,
                                   String departmentName){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }


}
