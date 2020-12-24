package com.lkl.test;

import com.lkl.dao.PhoneDao;
import com.lkl.dao.UserDao;
import com.lkl.dao.impl.PhoneDaoImpl;
import com.lkl.dao.impl.UserDaoImpl;
import com.lkl.entity.Dog;
import com.lkl.entity.Phone;
import com.lkl.entity.User;
import com.lkl.service.DogService;
import com.lkl.service.PhoneService;
import com.lkl.service.UserService;
import com.lkl.service.impl.DogServiceImpl;
import com.lkl.service.impl.PhoneServiceImpl;
import com.lkl.service.impl.UserServiceImpl;
import com.lkl.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDemo {

    UserDao userDao = new UserDaoImpl();
    UserService userService = new UserServiceImpl();
    PhoneService phoneService = new PhoneServiceImpl();
    PhoneDao phoneDao = new PhoneDaoImpl();
    DogService dogService = new DogServiceImpl();

    @Test
    public void testJDBC() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void testSelectAll() {
        List<User> list = userDao.selectAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectById() {
        User user = userDao.selectById(3);
        System.out.println(user);
    }

    @Test
    public void testLogin() {
        User user = userService.login("admin", "123456");
        System.out.println(user);
    }

    @Test
    public void testPhoneGetAll() {
        List<Phone> phoneList = phoneService.getAll();
        for (Phone phone : phoneList) {
            System.out.println(phone);
        }
    }

    @Test
    public void testPhoneGetCount() {
        int count = phoneDao.getCount();
        System.out.println(count);
    }

    @Test
    public void testQueryPage(){
        List<Phone> list = phoneDao.selectByPage(1, 2);
        for (Phone p : list) {
            System.out.println(p.getPmodel());
        }
    }

    @Test
    public void testDogQueryPage(){
        List<Dog> list = dogService.getPage(1, 2);
        for (Dog dog : list) {
            System.out.println(dog.getDname());
        }
    }

    @Test
    public void testDogGetCount(){
        System.out.println(dogService.getCount());
    }

    @Test
    public void testDnameNotExist(){
        boolean flag = dogService.isNameNotExist("老黄狗");
        System.out.println(flag);
    }

}
