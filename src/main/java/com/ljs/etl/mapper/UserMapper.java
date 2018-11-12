package com.ljs.etl.mapper;

import com.ljs.etl.bean.User;

import java.util.List;

public interface UserMapper {

    void save(User user);

    void update(User user);

    void delete(int id);

    User findById(int id);

    List<User> findAll();

}