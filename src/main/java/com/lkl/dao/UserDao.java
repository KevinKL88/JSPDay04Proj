package com.lkl.dao;

import com.lkl.entity.User;

import java.util.List;

public interface UserDao {
    User selectById(int id);

    List<User> selectAll();

    User selectByName(String username);
}
