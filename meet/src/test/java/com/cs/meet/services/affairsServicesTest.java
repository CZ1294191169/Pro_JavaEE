package com.cs.meet.services;

import com.cs.meet.dto.Affaircheckcondition;
import com.cs.meet.dto.Chartroomidcondition;
import com.cs.meet.dto.Meetdistributecondition;
import com.cs.meet.dto.Userappcondition;
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
public class affairsServicesTest {

    @Autowired
    affairsServices affairsServices;

    @Test
    public void testaff() throws Exception {
       List<Object[]> list =  affairsServices.affairchenck();

       List<Affaircheckcondition> affaircheckconditions = convertUtil.castEntity(list,Affaircheckcondition.class);

       System.out.println(affaircheckconditions.size());



       System.out.println(affaircheckconditions.get(0).getRoomName());
    }

    @Test
    public void testupdate()
    {
        int effect = affairsServices.updateAffairstatus(17);
        System.out.println(effect);
    }

    @Test
    public void testgetinfo() throws Exception {
        List<Object[]> list = affairsServices.Getmeetuseinfo();
        List<Chartroomidcondition> chartroomidconditionList = convertUtil.castEntity(list,Chartroomidcondition.class);

        System.out.println(chartroomidconditionList.size());

        System.out.println(chartroomidconditionList.get(0).getRoomName());
        System.out.println(chartroomidconditionList.get(0).getRoomId());
        System.out.println(chartroomidconditionList.get(0).getRoomNum());
        System.out.println(chartroomidconditionList.get(3).getRoomName());
        System.out.println(chartroomidconditionList.get(3).getRoomId());
        System.out.println(chartroomidconditionList.get(3).getRoomNum());
    }

    @Test
    public void testdistribute() throws Exception {
        List<Object[]> list = affairsServices.Getmeettimepush();
        List<Meetdistributecondition> meetdistributeconditionList = convertUtil.castEntity(list,Meetdistributecondition.class);

        System.out.println(meetdistributeconditionList.size());

        System.out.println(meetdistributeconditionList.get(0).getName());
        System.out.println(meetdistributeconditionList.get(0).getNum());
        System.out.println(meetdistributeconditionList.get(1).getName());
        System.out.println(meetdistributeconditionList.get(1).getNum());
    }

    @Test
    public void testuserappLiset() throws Exception {
        List<Object[]> list = affairsServices.GetuserappList();
        List<Userappcondition> userappconditions = convertUtil.castEntity(list,Userappcondition.class);


        System.out.println(userappconditions.size());

        System.out.println(userappconditions.get(0).getUserName());
        System.out.println(userappconditions.get(0).getUserId());
        System.out.println(userappconditions.get(0).getNum());
        System.out.println(userappconditions.get(1).getUserName());
        System.out.println(userappconditions.get(1).getUserId());
        System.out.println(userappconditions.get(1).getNum());
    }

}
