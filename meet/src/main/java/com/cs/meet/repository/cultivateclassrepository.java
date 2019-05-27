package com.cs.meet.repository;

import com.cs.meet.entity.Cultivate_class;
import com.cs.meet.entity.Cultivate_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface cultivateclassrepository extends JpaRepository<Cultivate_class,Integer>, JpaSpecificationExecutor<Cultivate_class> {
}
