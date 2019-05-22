package com.cs.meet.repository;

import com.cs.meet.entity.Meeting_log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface meetinglogrepository extends JpaRepository<Meeting_log,Integer>, JpaSpecificationExecutor<Meeting_log> {
}
