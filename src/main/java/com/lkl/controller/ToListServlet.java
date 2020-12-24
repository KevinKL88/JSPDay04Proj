package com.lkl.controller;

import com.lkl.entity.Computer;
import com.lkl.entity.Dog;
import com.lkl.entity.Phone;
import com.lkl.entity.User;
import com.lkl.service.ComputerService;
import com.lkl.service.DogService;
import com.lkl.service.PhoneService;
import com.lkl.service.UserService;
import com.lkl.service.impl.ComputerServiceImpl;
import com.lkl.service.impl.DogServiceImpl;
import com.lkl.service.impl.PhoneServiceImpl;
import com.lkl.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ToListServlet",urlPatterns = "/toList.do")
public class ToListServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    ComputerService computerService = new ComputerServiceImpl();
    DogService dogService = new DogServiceImpl();
    PhoneService phoneService = new PhoneServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        this.getData(request, response);
        //跳转至展示页面
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    public void getData(HttpServletRequest request, HttpServletResponse response) {
        //获得所有用户
        List<User> userList = userService.getAll();
        request.setAttribute("userList",userList);
        //获得所有Computer数据
        List<Computer> computers = computerService.getAll();
        request.setAttribute("computerList",computers);
        //获得所有Dog数据
        List<Dog> dogList = dogService.getAll();
        request.setAttribute("dogList", dogList);
        //获得所有Phone数据
        List<Phone> phoneList = phoneService.getAll();
        request.setAttribute("phoneList",phoneList);
    }
}
