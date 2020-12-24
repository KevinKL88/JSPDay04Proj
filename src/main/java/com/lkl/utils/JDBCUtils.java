package com.lkl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static final String driver;
    private static final String url;
    private static final String user;
    private static final String password;

    static {
        //创建properties对象
        Properties prop = new Properties();
        //利用类的加载器方式读取属性文件
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            //properties对象属性文件加载输入流
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化属性
        driver = prop.getProperty("driver");
        url = prop.getProperty("url");
        user = prop.getProperty("user");
        password = prop.getProperty("password");
    }

    /**
     * 加载JDBC驱动
     * @throws ClassNotFoundException
     */
    public static void loadDriver() throws ClassNotFoundException {
        Class.forName(driver);
    }

    /**
     * 获取JDBC连接
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        loadDriver();
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     * @param conn
     * @param stmt
     */
    public static void close(Connection conn, Statement stmt) {
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
