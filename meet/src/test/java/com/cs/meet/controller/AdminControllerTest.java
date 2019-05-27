package com.cs.meet.controller;

import com.cs.meet.entity.User_info;
import com.cs.meet.services.UserinfoServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminControllerTest {

    @Autowired
    UserinfoServices userinfoServices;

    @Test
    @Transactional
    public void testdelete(){
        User_info info =  userinfoServices.findByUserCode("1");
       userinfoServices.deleteById(info.getUserId());


    }

}
