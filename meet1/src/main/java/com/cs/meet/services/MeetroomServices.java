package com.cs.meet.services;

import com.cs.meet.entity.Affairs_table;
import com.cs.meet.entity.Meeting_room;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeetroomServices extends JpaRepository<Meeting_room,Integer> {

    @Query(value = "select room_id,room_name from meeting_room",
            nativeQuery = true)
    public List<Object[]> findall();

    @Query(value = "select room_name from meeting_room where room_Id =:roomId",
            nativeQuery = true)
    public String findByroomId(@Param("roomId") Integer roomId);


}
