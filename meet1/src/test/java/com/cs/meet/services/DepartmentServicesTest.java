package com.cs.meet.services;

import com.cs.meet.dto.Userdepartmentcondition;
import com.cs.meet.util.convertUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServicesTest {

    @Autowired
    DepartmentServices departmentServices;

    @Test
    public void testservice() throws Exception {
        List<Object[]> list = departmentServices.findDepartment();

        List<Userdepartmentcondition> userdepartmentconditionList = convertUtil.castEntity(list,Userdepartmentcondition.class);

        System.out.println(userdepartmentconditionList.size());

        System.out.println(userdepartmentconditionList.get(1).getDepartmentName());
    }

}
