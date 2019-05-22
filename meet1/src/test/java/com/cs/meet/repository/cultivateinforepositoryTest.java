package com.cs.meet.repository;

import com.cs.meet.entity.Cultivate_info;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class cultivateinforepositoryTest {

    @Autowired
    cultivateinforepository cultivateinforepository;

    @Test
    public void testnew()
    {
        Cultivate_info cultivate_info = new Cultivate_info();
        cultivate_info.setCultivateName("测试");
        cultivate_info.setCultivatPeo(10);
        cultivateinforepository.save(cultivate_info);
    }

    @Test
    public void testdelete()
    {
        cultivateinforepository.deleteById(4);
    }

    @Test
    public void change()
    {
        Cultivate_info cultivate_info = cultivateinforepository.findById(3).get();
        cultivate_info.setCultivateName("Vue.js进阶");
        cultivateinforepository.save(cultivate_info);
    }

}
