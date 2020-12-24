package com.lkl.controller.phone;

import com.lkl.entity.Phone;
import com.lkl.service.PhoneService;
import com.lkl.service.impl.PhoneServiceImpl;
import com.lkl.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhonePageAction",urlPatterns = "/phonePage.do")
public class PhonePageAction extends HttpServlet {
    PhoneService phoneService = new PhoneServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String curPage = request.getParameter("curPageNo");
        int curPageNo = 1;
        if (curPage != null) {
            curPageNo = Integer.parseInt(curPage);
        }
        int pageSize = 3;
        int count = phoneService.getCount();
        Page page = new Page();
        page.setCurPageNo(curPageNo);
        page.setPageSize(pageSize);
        page.setTotalCount(count);
        List<Phone> list = phoneService.getPage(curPageNo, pageSize);
        request.setAttribute("phoneList", list);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/phonePageList.jsp").forward(request,response);
    }
}
