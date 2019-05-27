package com.cs.meet.repository;

import com.cs.meet.entity.Meet_category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface meetcategoryrepository extends JpaRepository<Meet_category,Integer>, JpaSpecificationExecutor<Meet_category> {
}
