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

@WebServlet(name = "AddPhoneServlet",urlPatterns = "/addPhone.do")
public class AddPhoneServlet extends HttpServlet {
    private PhoneService phoneService = new PhoneServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收数据
        String pbrand = request.getParameter("p_brand");
        String pmodel = request.getParameter("p_model");
        double psize = Double.parseDouble(request.getParameter("p_size"));
        double pprice = Double.parseDouble(request.getParameter("p_price"));
        //封装数据
        Phone phone = new Phone();
        phone.setPbrand(pbrand);
        phone.setPmodel(pmodel);
        phone.setPsize(psize);
        phone.setPprice(pprice);
        //调用业务层代码
        phoneService.add(phone);
        //跳转至数据展示处理Servlet
        response.sendRedirect("/toList.do");
    }
}
