package com.lkl.controller.computer;

import com.lkl.service.ComputerService;
import com.lkl.service.impl.ComputerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckComputerModel",urlPatterns = "/checkComputerModel.do")
public class CheckComputerModel extends HttpServlet {
    private ComputerService computerService = new ComputerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cmodel
        String cmodel = request.getParameter("c_model");
        //调用业务层代码
        boolean flag = computerService.isModelNotExist(cmodel);
        //向前端响应数据
        if (flag) {
            response.getWriter().println("<p style='color:green'>型号可用</p>");
        }else {
            response.getWriter().println("<p style='color:red'>型号已存在</p>");
        }
    }
}