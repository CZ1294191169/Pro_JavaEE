package com.cs.meet.services.servicesImpl;

import com.cs.meet.entity.User_info;
import com.cs.meet.repository.userrepository;
import com.cs.meet.services.UserinfoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserserImpl implements UserinfoServices {

    @Autowired
    userrepository userrepository;

    @Override
    public User_info findByusercode(String userCode) {
        return null;
    }

    @Override
    public User_info findByUserName(String userName) {

        return userrepository.findByUserName(userName);
    }

    @Override
    public User_info findByUserCode(String userCode) {
        return userrepository.findByUserCode(userCode);
    }

    @Override
    public List<User_info> findByDepartmentId(int departmentId) {
        return userrepository.findByDepartmentId(departmentId);
    }

    @Override
    public List<User_info> findByUserStatus(int userStatus) {
        return userrepository.findByUserStatus(userStatus);
    }

    @Override
    public List<User_info> findAll() {
        return userrepository.findAll();
    }

    @Override
    public List<User_info> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<User_info> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<User_info> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(User_info user_info) {

    }

    @Override
    public void deleteAll(Iterable<? extends User_info> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends User_info> S save(S s) {
        return null;
    }

    @Override
    public <S extends User_info> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<User_info> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends User_info> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<User_info> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public User_info getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends User_info> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends User_info> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends User_info> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends User_info> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends User_info> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends User_info> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public int deleteByUserName(String userName) {
        return userrepository.deleteByUserName(userName);

    }

    @Override
    public int deleteByUserCode(String userCode) {
        return userrepository.deleteByUserCode(userCode);
    }

    @Override
    public List<Object[]> selectByCode(Integer userid) {
        return null;
    }

    @Override
    public List<Object[]> selectByempCode(String empcode) {
        return null;
    }

    @Override
    public List<Object[]> selectByuserId(Integer userId) {
        return null;
    }

    @Override
    public List<Object[]> GetfullUser() {
        return null;
    }


}
