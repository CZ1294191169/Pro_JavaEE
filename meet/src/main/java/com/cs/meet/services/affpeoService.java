package com.cs.meet.services;

import com.cs.meet.entity.Affairs_people;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface affpeoService extends JpaRepository<Affairs_people,Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into affairs_people(user_id,affairs_id) values (?1,?2)",
            nativeQuery = true)
    public void Insertintoaffpeo(Integer userId,Integer affairsId);


    @Modifying
    @Transactional
    @Query(value = "update affairs_people set status=0 where people_id=:peopleId",
            nativeQuery = true)
    public void updateStatus(@Param("peopleId") Integer peopleId);



}
