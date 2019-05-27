package com.cs.meet.repository;

import com.cs.meet.entity.Affairs_table;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class affairstablerepositoryTest {

    @Autowired
    affairstablerepository affairstablerepository;

    @Test
    public void testnew() throws ParseException {
        Affairs_table affairs_table = new Affairs_table();


        affairs_table.setUserId(1);
        affairs_table.setRoomId(1);
        affairs_table.setTheme("生物信息技术在社会中的用处");
        affairs_table.setFile("暂无");
        affairs_table.setParticipate(20);
        affairs_table.setAffairsStatus(0);
//        Date date = new Date();
//        Calendar cals = Calendar.getInstance();
//        Calendar cale = Calendar.getInstance();
//        cals.set(2019,4,22,17,30);
//        cale.set(2019,4,22,19,30);
        String ds = "2019-04-22 15:30:00";
        String de = "2019-04-22 19:30:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date das = sdf.parse(ds);
        Date dae = sdf.parse(de);
//        Timestamp ts = Timestamp.valueOf(ds)
//        java.sql.Date pstart=java.sql.Date.valueOf(dates);
//        java.sql.Date pend=java.sql.Date.valueOf(datee);
        System.out.println(das.getTime());
        System.out.println(dae.getTime());
        affairs_table.setArrangementPeriodstart(das);
        System.out.println(affairs_table.getArrangementPeriodstart());
        affairs_table.setArrangementPeriodend(dae);
        affairstablerepository.save(affairs_table);
    }

    @Test
    public void testdelete()
    {
        affairstablerepository.deleteById(2);
    }

    @Test
    public void testchange() throws ParseException {
        Affairs_table affairs_table = affairstablerepository.findById(1).get();
        String de = "2019-04-22 18:50:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dae = sdf.parse(de);
        affairs_table.setArrangementPeriodend(dae);

        affairstablerepository.save(affairs_table);
    }

}
