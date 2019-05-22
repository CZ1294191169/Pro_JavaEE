package com.cs.meet.repository;


import com.cs.meet.entity.User_info;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class userrepositoryTest {
    @Autowired
    userrepository ur;


    @Test
    public void testfindall(){
        List<User_info> userList = new ArrayList<User_info>();
        userList = ur.findAll();
        System.out.println("hey!!!!!!!"+userList.get(0).getUserName());
    }

    @Test
    public void testnew(){
        User_info userInfo = new User_info();
        userInfo.setUserCode("2016051138");
        userInfo.setLoginPassword("12345");
        userInfo.setDepartmentId(1);
        userInfo.setUserName("小白");
        //userInfo.setUserStatus(0);

        ur.save(userInfo);
    }

    @Test
    public void testdelete(){
        ur.deleteById(2);
    }

    @Test
    public void testupdate(){


        User_info userInfo =  ur.findById(1).get();

        //userInfo.setUserStatus(2);

        ur.save(userInfo);


    }

    @Test
    public void testfindbyname()
    {
        User_info user_infos = ur.findByUserName("王阳明");
        System.out.println(user_infos.getLoginIcon());
    }






}
