package com.lkl.controller.dog;

import com.lkl.entity.Dog;
import com.lkl.service.DogService;
import com.lkl.service.impl.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToUpdateDogServler",urlPatterns = "/toUpdateDog.do")
public class ToUpdateDogServler extends HttpServlet {
    DogService dogService = new DogServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer did = Integer.parseInt(request.getParameter("did"));
        Dog dog = dogService.get(did);
        //将对象传递至前端
        request.setAttribute("dog", dog);
        //跳转至修改页面
        request.getRequestDispatcher("/updateDog.jsp").forward(request,response);
    }
}
