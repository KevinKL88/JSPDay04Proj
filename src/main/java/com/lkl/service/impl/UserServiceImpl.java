package com.lkl.service.impl;

import com.lkl.dao.UserDao;
import com.lkl.dao.impl.UserDaoImpl;
import com.lkl.entity.User;
import com.lkl.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User get(int id) {
        return userDao.selectById(id);
    }

    /**
     * 获取所有用户
     * @return
     */
    @Override
    public List<User> getAll() {
        return userDao.selectAll();
    }

    /**
     * 用户登录验证方法
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        User user = userDao.selectByName(username);
        if (user == null) {
            return null;
        } else if (password.equals(user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
}
