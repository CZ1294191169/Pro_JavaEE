package com.cs.meet.repository;

import com.cs.meet.entity.Meeting_room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface meetroomrepository extends JpaRepository<Meeting_room,Integer>, JpaSpecificationExecutor<Meeting_room> {
}
