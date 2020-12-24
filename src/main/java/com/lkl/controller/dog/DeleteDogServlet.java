package com.lkl.controller.dog;

import com.lkl.service.DogService;
import com.lkl.service.impl.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteDogServlet",urlPatterns = "/deleteDog.do")
public class DeleteDogServlet extends HttpServlet {
    DogService dogService = new DogServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int did = Integer.parseInt(request.getParameter("did"));
        dogService.remove(did);
        response.sendRedirect("/toList.do");
    }
}
