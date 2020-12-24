package com.lkl.controller.phone;

import com.lkl.service.PhoneService;
import com.lkl.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckModel",urlPatterns = "/checkModel.do")
public class CheckModel extends HttpServlet {
    private PhoneService phoneService = new PhoneServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取pmodel
        String pmodel = request.getParameter("p_model");
        //调用业务层代码
        boolean flag = phoneService.isModelNotExist(pmodel);
        //向前端响应数据
        if (flag) {
            response.getWriter().println("<p style='color:green'>型号可用</p>");
        }else {
            response.getWriter().println("<p style='color:red'>型号已存在</p>");
        }
    }
}
