package com.cs.meet.repository;

import com.cs.meet.entity.Message_log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface messagerepository extends JpaRepository<Message_log,Integer>, JpaSpecificationExecutor<Message_log> {
}
