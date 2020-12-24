package com.lkl.service;

import com.lkl.entity.User;

import java.util.List;

public interface UserService {
    User get(int id);

    List<User> getAll();

    User login(String username,String password);
}
