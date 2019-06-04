package com.cs.meet.services;


import com.cs.meet.entity.Message_log;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageServices extends JpaRepository<Message_log,Integer> {

    public List<Message_log> findByUserId(@Param("userId") Integer userId);
}
