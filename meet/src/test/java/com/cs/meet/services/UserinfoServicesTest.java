package com.cs.meet.services;

import com.cs.meet.dto.UserFullmessagecondition;
import com.cs.meet.dto.UserMeetCondition;
import com.cs.meet.entity.User_info;
import com.cs.meet.util.DateUtil;
import com.cs.meet.util.convertUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserinfoServicesTest {

    @Autowired
    UserinfoServices userinfoServices;

    @Test
    public void trytest() throws Exception {
        List<Object[]> select =userinfoServices.selectByCode(3);
       List<UserMeetCondition> test = convertUtil.castEntity(select, UserMeetCondition.class);
        Assert.assertTrue(test.size() > 0);

        System.out.println(test.get(0).getUserName());
       // System.out.println(test.get(0).getRomName());
        System.out.println(test.get(0).getTheme());
       // System.out.println(test.get(0).getMeetSummarize());
    }

    @Test
    public void tryempcode() throws Exception {
        List<Object[]> select =userinfoServices.selectByempCode();
        List<UserMeetCondition> test = convertUtil.castEntity(select, UserMeetCondition.class);
        Assert.assertTrue(test.size() > 0);

        System.out.println(test.get(0).getUserName());
        System.out.println(test.get(0).getRoomName());
        System.out.println(test.get(0).getTheme());
        System.out.println(test.get(0).getFile());
        System.out.println(DateUtil.Convertdatetoymdhm(DateUtil.ConvertTimeStamptodate(test.get(0).getArrangementPeriodstart())));
        System.out.println(DateUtil.Convertdatetoymdhm(DateUtil.ConvertTimeStamptodate(test.get(0).getArrangementPeriodend())));
    }


    @Test
    public void getfull() throws Exception {
        List<Object[]> list = userinfoServices.GetfullUser();
        System.out.println(list.size());
        List<UserFullmessagecondition> userFullmessageconditions = convertUtil.castEntity(list,UserFullmessagecondition.class);
        System.out.println(userFullmessageconditions.size());
    }

    @Test
    public void  getfind()
    {
        User_info userInfo = userinfoServices.findByusercode("xl");
        System.out.println(userInfo.getUserId());
    }

}
