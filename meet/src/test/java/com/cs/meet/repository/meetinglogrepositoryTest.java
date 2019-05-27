package com.cs.meet.repository;

import com.cs.meet.entity.Meeting_log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class meetinglogrepositoryTest {

    @Autowired
    meetinglogrepository meetinglogrepository;


    @Test
    public void testnew() throws ParseException {
        Meeting_log meeting_log = new Meeting_log();

        meeting_log.setAffairsId(1);
        meeting_log.setUserId(1);
        meeting_log.setRoomId(1);
        meeting_log.setTheme("测试");
        meeting_log.setFile("暂无");
        meeting_log.setParticipate(20);
        meeting_log.setMeetingSummarize("暂无");
        meeting_log.setMeetingImg("暂无");
        String ds = "2019-04-22 15:30:00";
        String de = "2019-04-22 19:30:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date das = sdf.parse(ds);
        Date dae = sdf.parse(de);
        meeting_log.setArrangementPeriodstart(das);
        meeting_log.setArrangementPeriodend(dae);
        meetinglogrepository.save(meeting_log);
    }

    @Test
    public void testdelete()
    {
        meetinglogrepository.deleteById(2);
    }

    @Test
    public void testchange()
    {
        Meeting_log meeting_log = meetinglogrepository.findById(1).get();
        meeting_log.setMeetingImg("图片是我");
        meeting_log.setMeetingSummarize("生物工程技术将是200年来最有展望的领域");
        meetinglogrepository.save(meeting_log);
    }

}
