package com.cs.meet.repository;

import com.cs.meet.entity.Meeting_room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class meetroomrepositoryTest {

    @Autowired
    meetroomrepository meetroomrepository;

    @Test
    public void testnew()
    {
        Meeting_room meeting_room = new Meeting_room();
        meeting_room.setRoomName("test");
        meetroomrepository.save(meeting_room);
    }

    @Test
    public void testdelete()
    {
        meetroomrepository.deleteById(2);
    }

    @Test
    public void testchange()
    {
        Meeting_room meeting_room = meetroomrepository.findById(1).get();

        meeting_room.setRoomIcon("测试缩略图");

        meetroomrepository.save(meeting_room);
    }

}
