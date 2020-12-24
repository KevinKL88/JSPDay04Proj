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

@WebServlet(name = "AddComputerServlet",urlPatterns = "/addComputer.do")
public class AddComputerServlet extends HttpServlet {
    private ComputerService computerService = new ComputerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得数据
        String cbrand = request.getParameter("c_brand");
        String cmodel = request.getParameter("c_model");
        String ccpu = request.getParameter("c_cpu");
        String cgpu = request.getParameter("c_gpu");
        //封装数据
        Computer computer = new Computer();
        computer.setcBrand(cbrand);
        computer.setcModel(cmodel);
        computer.setcCpu(ccpu);
        computer.setcGpu(cgpu);
        //调用业务层代码
        computerService.add(computer);
        response.sendRedirect("/toList.do");
    }
}
