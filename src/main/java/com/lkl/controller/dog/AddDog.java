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

@WebServlet(name = "AddDog",urlPatterns = "/addDog.do")
public class AddDog extends HttpServlet {
    private DogService dogService = new DogServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端接收数据
        String dname = request.getParameter("d_name");
        String dspecies = request.getParameter("d_species");
        Integer dage = Integer.parseInt(request.getParameter("d_age"));
        //封装数据
        Dog dog = new Dog();
        dog.setDname(dname);
        dog.setDspecies(dspecies);
        dog.setAge(dage);
        //调用业务层代码
        dogService.add(dog);
        //跳转至数据展示页面
        request.getRequestDispatcher("/toList.do").forward(request, response);
    }
}
