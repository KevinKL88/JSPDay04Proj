package com.lkl.controller.computer;

import com.lkl.entity.Computer;
import com.lkl.service.ComputerService;
import com.lkl.service.impl.ComputerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToUpdateComputerServlet",urlPatterns = "/toUpdateComputer.do")
public class ToUpdateComputerServlet extends HttpServlet {
    private ComputerService computerService = new ComputerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得数据
        int cid = Integer.parseInt(request.getParameter("cid"));
        //获得需要修改的数据
        Computer computer = computerService.get(cid);
        request.setAttribute("computer", computer);
        request.getRequestDispatcher("/updateComputer.jsp").forward(request, response);
    }
}
