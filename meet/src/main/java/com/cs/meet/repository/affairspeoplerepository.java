package com.cs.meet.repository;

import com.cs.meet.entity.Affairs_people;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface affairspeoplerepository extends JpaRepository<Affairs_people,Integer>, JpaSpecificationExecutor<Affairs_people> {
}
