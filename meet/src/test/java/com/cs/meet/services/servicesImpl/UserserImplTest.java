package com.cs.meet.services.servicesImpl;

import com.cs.meet.entity.User_info;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.cs.meet.services.servicesImpl.UserserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserserImplTest {

    @Autowired
   UserserImpl userser;

    @Test
    public void testSearch()
    {
        List<User_info> user_infos= userser.findByDepartmentId(1);
        assertEquals(2,user_infos.size());
        assertEquals("小凯",user_infos.get(1).getUserName());

    }



}
