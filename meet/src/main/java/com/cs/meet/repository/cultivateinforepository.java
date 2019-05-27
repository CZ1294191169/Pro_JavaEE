package com.cs.meet.repository;

import com.cs.meet.entity.Cultivate_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface cultivateinforepository extends JpaRepository<Cultivate_info,Integer>, JpaSpecificationExecutor<Cultivate_info> {
}
