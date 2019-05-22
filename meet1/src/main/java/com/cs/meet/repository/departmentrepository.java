package com.cs.meet.repository;

import com.cs.meet.entity.Department_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface departmentrepository extends JpaRepository<Department_table,Integer>, JpaSpecificationExecutor<Department_table> {
}
