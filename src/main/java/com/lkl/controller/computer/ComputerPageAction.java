package com.lkl.controller.computer;

import com.lkl.entity.Computer;
import com.lkl.entity.Dog;
import com.lkl.service.ComputerService;
import com.lkl.service.impl.ComputerServiceImpl;
import com.lkl.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ComputerPageAction",urlPatterns = "/computerPage.do")
public class ComputerPageAction extends HttpServlet {
    private ComputerService computerService = new ComputerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String curPage = request.getParameter("curPageNo");
        //设置默认值当前页为1
        int curPageNo = 1;
        if (curPage != null) {
            curPageNo = Integer.parseInt(curPage);
        }
        //设置页面大小
        int pageSize = 3;
        //获得总记录数
        int count = computerService.getCount();
        //封装Page
        Page page = new Page();
        page.setPageSize(pageSize);
        page.setCurPageNo(curPageNo);
        page.setTotalCount(count);
        //查询当页记录
        List<Computer> list = computerService.getPage(curPageNo, pageSize);
        //将数据传至前端
        request.setAttribute("computerList", list);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/computerPageList.jsp").forward(request, response);
    }
}
