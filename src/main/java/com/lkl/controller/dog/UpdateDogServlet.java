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

@WebServlet(name = "UpdateDogServlet",urlPatterns = "/updateDog.do")
public class UpdateDogServlet extends HttpServlet {
    DogService dogService = new DogServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端传递的参数
        Integer did = Integer.parseInt(request.getParameter("did"));
        String dname = request.getParameter("d_name");
        String dspecies = request.getParameter("d_species");
        Integer age = Integer.parseInt(request.getParameter("d_age"));
        //根据did查找需要修改的数据
        Dog dog = dogService.get(did);
        dog.setDname(dname);
        dog.setDspecies(dspecies);
        dog.setAge(age);
        dogService.edit(dog);
        response.sendRedirect("/toList.do");
    }
}
