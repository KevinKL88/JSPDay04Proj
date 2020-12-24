package com.lkl.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AccessCountListener implements HttpSessionListener{

    // Public constructor is required by servlet spec
    public AccessCountListener() {
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    private int count = 0;
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        count++;
        System.out.println("session创建成功");
        //System.out.println("当前访问人数为："+count);
        se.getSession().getServletContext().setAttribute("count",count);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        count--;
        System.out.println("session销毁成功");
        //System.out.println("当前访问人数为："+count);
    }

}
