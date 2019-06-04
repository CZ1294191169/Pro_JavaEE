package com.cs.meet.services;

import com.cs.meet.dto.Affaircheckcondition;
import com.cs.meet.dto.Chartroomidcondition;
import com.cs.meet.entity.Affairs_table;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.io.InputStream;
import java.util.List;

public interface affairsServices extends JpaRepository<Affairs_table,Integer> {


    @Query(value ="select affairs_id,user_name,participate,room_name,file,arrangement_periodstart,arrangement_periodend,affairs_table.create_time\n" +
            "from affairs_table left join user_info on user_info.user_id=affairs_table.user_id\n" +
            "left join meeting_room on meeting_room.room_id=affairs_table.room_id"+
            " where affairs_table.affairs_status<>1\n" +
            "and affairs_table.affairs_status<>-1",
            nativeQuery = true)
   public List<Object[]> affairchenck();



    @Modifying
    @Transactional
    @Query(value = "update affairs_table set affairs_status = '1' where affairs_id =:affairsId",
            nativeQuery = true)
    public Integer updateAffairstatus(@Param("affairsId") Integer affairsId);

    @Modifying
    @Transactional
    @Query(value = "update affairs_table set affairs_status = '-1' where affairs_id =:affairsId",
            nativeQuery = true)
    public Integer ufailAffairstatus(@Param("affairsId") Integer affairsId);



    @Query(value = "select affairs_id,user_name,participate,room_name,file,arrangement_periodstart,arrangement_periodend,affairs_table.create_time,affairs_status\n" +
            "from affairs_table left join user_info on user_info.user_id=affairs_table.user_id\n" +
            "left join meeting_room on meeting_room.room_id=affairs_table.room_id"+
            " where affairs_table.user_id=:userId",
        nativeQuery = true)
    public List<Object[]> GetAppListByUserId(@Param("userId") Integer userId);


    @Query(value = "select room_name,affairs_table.room_id,COUNT(*) as 'room_num'  from affairs_table,meeting_room\n" +
            "\t\t\t\t\t\t\t\t\t\t\twhere \taffairs_table.room_id  = meeting_room.room_id\n" +
            "\t\t\t\t\t\t\t\t\t\t\tGROUP BY room_id",
           nativeQuery = true)
    public List<Object[]> Getmeetuseinfo();


    @Query(value = "SELECT DATE_FORMAT(arrangement_periodstart, '%H:00:00') AS time, COUNT(*) AS num\n" +
            "FROM affairs_table\n" +
            "GROUP BY time\n" +
            "ORDER BY time",
            nativeQuery = true)
     public List<Object[]> Getmeettimepush();

    @Query(value = "SELECT DATE_FORMAT(arrangement_periodstart, '%Y-%m-%d') AS time, COUNT(*) AS num\n" +
            "FROM affairs_table\n" +
            "GROUP BY time\n" +
            "ORDER BY time;\n",
          nativeQuery = true)
    public List<Object[]> Getmeettimepushbyymd();

    @Query(value = "select user_name,affairs_table.user_id,COUNT(*) AS num from affairs_table\n" +
            "\tleft join user_info on affairs_table.user_id = user_info.user_id\n" +
            "\tGROUP BY affairs_table.user_id\n" +
            "\tORDER BY affairs_table.user_id",
            nativeQuery = true)
    public List<Object[]> GetuserappList();




}
