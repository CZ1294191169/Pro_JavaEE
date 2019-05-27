package com.cs.meet.repository;

import com.cs.meet.entity.User_info;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface userrepository extends JpaRepository<User_info,Integer>, JpaSpecificationExecutor<User_info> {

//    @Query(value = "select * from user_info where user_name = :userName",nativeQuery=true)
//    List<User_info> findByUserName(@Param("userName") String userName);
    User_info findByUserCode(String userCode);
    @Query(value = "select * from user_info where department_id = :departmentId",nativeQuery=true)
    List<User_info> findByDepartmentId(@Param("departmentId")int departmentId);
    List<User_info> findByUserStatus(int userStatus);

    User_info findByUserName(String userName);

    int deleteByUserName(String userName);
    int deleteByUserCode(String userCode);


}
