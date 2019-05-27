package com.cs.meet.repository;

import com.cs.meet.entity.Cultivate_class;
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
public class cultivateclassrepositoryTest {

    @Autowired
    cultivateclassrepository cultivateclassrepository;

    @Test
    public void testnew() throws ParseException {
        Cultivate_class cultivate_class  = new Cultivate_class();
        cultivate_class.setCultivateId(2);
        cultivate_class.setUserId(1);
        String j = "2019-04-23";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date das = sdf.parse(j);
        cultivate_class.setJointime(das);
        cultivateclassrepository.save(cultivate_class);
    }

    @Test
    public void testdelete()
    {
        cultivateclassrepository.deleteById(2);
    }

    @Test
    public void testchange()
    {
        Cultivate_class cultivate_class = cultivateclassrepository.findById(2).get();
        cultivate_class.setCultivateId(1);
        cultivateclassrepository.save(cultivate_class);
    }

}
