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

@WebServlet(name = "UpdatePhoneServlet",urlPatterns = "/updatePhone.do")
public class UpdatePhoneServlet extends HttpServlet {
    private PhoneService phoneService = new PhoneServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端页面接收数据
        int pid = Integer.parseInt(request.getParameter("pid"));
        String pbrand = request.getParameter("p_brand");
        String pmodel = request.getParameter("p_model");
        double psize = Double.parseDouble(request.getParameter("p_size"));
        double pprice = Double.parseDouble(request.getParameter("p_price"));
        //通过pid查找要修改的数据
        Phone phone = phoneService.get(pid);
        //封装前端传的值
        phone.setPsize(psize);
        phone.setPbrand(pbrand);
        phone.setPmodel(pmodel);
        phone.setPprice(pprice);
        //调用业务层代码修改方法
        phoneService.edit(phone);
        request.getRequestDispatcher("/toList.do").forward(request, response);
    }
}
