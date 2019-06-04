package com.cs.meet.services;

import com.cs.meet.entity.User_info;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.io.InputStream;
import java.util.List;


public interface UserinfoServices extends JpaRepository<User_info,Integer> {


    //查询
    User_info findByUserName(String userName);
    @Query(value = "select * from user_info where user_code =:userCode",
    nativeQuery = true)
    User_info findByusercode(@Param("userCode") String userCode);
    User_info findByUserCode( String userCode);
    List<User_info> findByDepartmentId(int departmentId);
    List<User_info> findByUserStatus(int userStatus);
    List<User_info> findAll();
    //修改,增加

    //删除
    int deleteByUserName(String userName);
    int deleteByUserCode(String userCode);

    @Query(
            value = "select user_info.department_id,department_table.department_name,user_info.user_name,meeting_room.room_name,\n" +
                    "affairs_table.theme,affairs_table.arrangement_periodstart,affairs_table.arrangement_periodend,affairs_table.participate\n" +
                    "from  affairs_table,user_info,meeting_room,department_table \n" +
                    "where affairs_table.user_id=user_info.user_id and\n" +
                    "user_info.department_id=department_table.department_id and\n" +
                    "meeting_room.room_id=affairs_table.room_id and \n" +
                    "user_info.department_id=:departmentid",

            nativeQuery = true
    )
    List<Object[]> selectByCode(@Param("departmentId") Integer departmentid);

    @Query(
            value = "select user_info.user_name,meeting_room.room_name,affairs_table.theme,affairs_table.file,affairs_table.arrangement_periodstart,affairs_table.arrangement_periodend\n" +
                    "                    from affairs_table left join user_info on user_info.user_id = affairs_table.user_id \n" +
                    "                     left join affairs_people on affairs_people.user_id = affairs_table.user_id  and affairs_people.affairs_id = affairs_table.affairs_id\n" +
                    "                    left join meeting_room on meeting_room.room_id = affairs_table.room_id\n" +
                    "                   \n" +
                    "                    where affairs_table.affairs_status<> 0\n" +
                    "                    and affairs_table.affairs_status<> -1\n" +
                    "                    and affairs_people.affairs_id = affairs_table.affairs_id",
            nativeQuery = true
    )
    List<Object[]> selectByempCode();


    @Query(
            value = "select affairs_table.theme,affairs_table.arrangement_periodstart,affairs_table.arrangement_periodend\n" +
                    "\t\tfrom affairs_table\n" +
                    "\t\t\t\t where affairs_table.affairs_status<>0 \n" +
                    "and affairs_table.affairs_status<> -1 \n"+
                    "and  affairs_table.user_id=:userId",
            nativeQuery = true
    )
    List<Object[]> selectByuserId(@Param("userId") Integer userId);


    @Query(
            value = "select user_name,emp_code,user_info.department_id,department_table.department_name\n" +
                    "\t,job_jointime,person_des,person_phone,person_email,user_status\n" +
                    "\tfrom user_info left join department_table on user_info.department_id = department_table.department_id",
            nativeQuery = true
    )
    List<Object[]> GetfullUser();

    @Query(
            value = "select user_id,user_name from user_info left join department_table on  department_table.department_id =  user_info.department_id\n" +
                    "where user_info.department_id=?2 " +
                    "and user_id<>?1",
            nativeQuery = true
    )
    List<Object[]> getAppUserList(Integer userId,Integer departmentId);





}
