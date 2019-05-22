package com.cs.meet.repository;

import com.cs.meet.entity.Department_table;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class departmentrepositoryTest {

    @Autowired
    departmentrepository departmentrepository;

    @Test
    public void testnew()
    {
        Department_table department_table = new Department_table();
        department_table.setDepartmentPho("13708202587");
        department_table.setDeapartmentEmail("9@163.com");
        department_table.setDepartmentName("test");
        departmentrepository.save(department_table);
    }

    @Test
    public void testdelete()
    {
        departmentrepository.deleteById(4);
    }

    @Test
    public void testchange()
    {
        Department_table department_table = departmentrepository.findById(2).get();

        department_table.setDeapartmentEmail("1622357726@qq.com");

        departmentrepository.save(department_table);
    }

}
