package com.cs.meet.repository;

import com.cs.meet.entity.Meet_category;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class meetcategoryrepositoryTest {

    @Autowired
    meetcategoryrepository meetcategoryrepository;

    @Test
    public void testnew()
    {
        Meet_category meet_category = new Meet_category();
        meet_category.setCategoryId(1);
        meet_category.setRoomId(1);
        meet_category.setCategoryName("测试用");

        meetcategoryrepository.save(meet_category);
    }

    @Test
    public void testdelete()
    {
        meetcategoryrepository.deleteById(2);
    }

    @Test
    public void testchange()
    {
        Meet_category meet_category = meetcategoryrepository.findById(1).get();

        meet_category.setCategoryName("小型私用");
        meetcategoryrepository.save(meet_category);
    }

}
