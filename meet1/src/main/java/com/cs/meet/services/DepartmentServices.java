package com.cs.meet.services;

import com.cs.meet.dto.Userdepartmentcondition;
import com.cs.meet.entity.Department_table;
import com.cs.meet.repository.departmentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentServices extends JpaRepository<Department_table,Integer> {



    @Query(value = "select department_id,department_name from department_table",
    nativeQuery = true)
    public List<Object[]> findDepartment();
}
