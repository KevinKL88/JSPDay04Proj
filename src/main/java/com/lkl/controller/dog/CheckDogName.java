package com.lkl.controller.dog;

import com.lkl.service.DogService;
import com.lkl.service.impl.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckDogName",urlPatterns = "/checkDogName.do")
public class CheckDogName extends HttpServlet {
    private DogService dogService = new DogServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得dname
        String dname = request.getParameter("dname");
        boolean flag = dogService.isNameNotExist(dname);
        //将flag响应至前端
        response.getWriter().println(flag);
        /*if (flag) {
            response.getWriter().println("<font color='green'>用户名可用</font>");
        }else {
            response.getWriter().println("<p color='red'>用户名已存在</p>");
        }*/
    }
}
