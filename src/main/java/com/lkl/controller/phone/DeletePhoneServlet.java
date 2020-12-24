package com.lkl.controller.phone;

import com.lkl.service.PhoneService;
import com.lkl.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeletePhoneServlet",urlPatterns = "/deletePhone.do")
public class DeletePhoneServlet extends HttpServlet {
    private PhoneService phoneService = new PhoneServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端接收pid
        int pid = Integer.parseInt(request.getParameter("pid"));
        //调用业务层代码删除方法
        phoneService.remove(pid);
        //重定向至数据展示Servlet
        response.sendRedirect("/toList.do");
    }
}
