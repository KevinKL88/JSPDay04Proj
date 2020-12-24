package com.lkl.controller.phone;

import com.lkl.entity.Phone;
import com.lkl.service.PhoneService;
import com.lkl.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 该Servlet用于将修改的数据传递至修改的前端页面
 */
@WebServlet(name = "ToUpdatePhoneServlet",urlPatterns = "/toUpdatePhone.do")
public class ToUpdatePhoneServlet extends HttpServlet {
    private PhoneService phoneService = new PhoneServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        //根据pid查询数据
        Phone phone = phoneService.get(pid);
        //将数据传递至前端显示
        request.setAttribute("phone", phone);
        request.getRequestDispatcher("/updatePhone.jsp").forward(request,response);
    }
}
