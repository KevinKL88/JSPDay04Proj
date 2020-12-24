package com.lkl.controller.computer;

import com.lkl.service.ComputerService;
import com.lkl.service.impl.ComputerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteComputerServlet",urlPatterns = "/deteteComputer.do")
public class DeleteComputerServlet extends HttpServlet {
    private ComputerService computerService = new ComputerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        computerService.remove(cid);
        response.sendRedirect("/toList.do");
    }
}
