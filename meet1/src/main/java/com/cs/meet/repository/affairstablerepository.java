package com.cs.meet.repository;

import com.cs.meet.entity.Affairs_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface affairstablerepository extends JpaRepository<Affairs_table,Integer>, JpaSpecificationExecutor<Affairs_table> {
}
