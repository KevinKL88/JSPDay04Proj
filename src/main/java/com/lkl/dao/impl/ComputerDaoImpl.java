package com.lkl.dao.impl;


import com.lkl.dao.ComputerDao;
import com.lkl.entity.Computer;
import com.lkl.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputerDaoImpl implements ComputerDao {
    /**
     * 添加方法
     * @param computer
     */
    @Override
    public void addComputer(Computer computer) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into computer value(null,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, computer.getcBrand());
            pstmt.setString(2, computer.getcModel());
            pstmt.setString(3, computer.getcCpu());
            pstmt.setString(4, computer.getcGpu());
            int i = pstmt.executeUpdate();
            System.out.println("成功添加" + i + "条");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
    }

    /**
     * 修改方法
     * @param computer
     */
    @Override
    public void updateComputer(Computer computer) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update computer set c_brand=?,c_model=?,c_cpu=?,c_gpu=? where cid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, computer.getcBrand());
            pstmt.setString(2, computer.getcModel());
            pstmt.setString(3, computer.getcCpu());
            pstmt.setString(4, computer.getcGpu());
            pstmt.setInt(5,computer.getCid());
            int i = pstmt.executeUpdate();
            System.out.println("成功修改" + i + "条");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
    }

    /**
     * 删除方法
     * @param cid
     */
    @Override
    public void deleteComputerById(int cid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from computer where cid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cid);
            int i = pstmt.executeUpdate();
            System.out.println("成功删除" + i + "条");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
    }

    /**
     * 根据id值查找
     * @param cid
     * @return
     */
    @Override
    public Computer selectComputerById(int cid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Computer computer = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from computer where cid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cid);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                computer = new Computer();
                computer.setCid(cid);
                computer.setcBrand(rs.getString("c_brand"));
                computer.setcModel(rs.getString("c_model"));
                computer.setcCpu(rs.getString("c_cpu"));
                computer.setcGpu(rs.getString("c_gpu"));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return computer;
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Computer> selectAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Computer> computers = new ArrayList<Computer>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from computer";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Computer computer = new Computer();
                computer.setCid(rs.getInt("cid"));
                computer.setcBrand(rs.getString("c_brand"));
                computer.setcModel(rs.getString("c_model"));
                computer.setcCpu(rs.getString("c_cpu"));
                computer.setcGpu(rs.getString("c_gpu"));

                computers.add(computer);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return computers;
    }

    @Override
    public int getCount() {
        int count = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select count(*) from computer";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            rs.next();
            count = rs.getInt(1);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
        return count;
    }

    @Override
    public List<Computer> selectByPage(int curPage, int pageSize) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Computer> computers = new ArrayList<Computer>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from computer limit ?,?";
            pstmt = conn.prepareStatement(sql);
            //计算当前页起始记录的下标
            int begin = (curPage-1)*pageSize;
            pstmt.setInt(1, begin);
            //设置页面大小
            pstmt.setInt(2,pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Computer computer = new Computer();
                computer.setCid(rs.getInt("cid"));
                computer.setcBrand(rs.getString("c_brand"));
                computer.setcModel(rs.getString("c_model"));
                computer.setcCpu(rs.getString("c_cpu"));
                computer.setcGpu(rs.getString("c_gpu"));

                computers.add(computer);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return computers;
    }

    @Override
    public boolean isModelNotExist(String cmodel) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //c_model是否存在的标志，true表示不存在，false表示存在
        boolean flag = true;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select c_model from computer";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("c_model").equals(cmodel)) {
                    //如果存在相同c_model，则将flag置为false
                    flag = false;
                    break;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt,rs);
        }
        return flag;
    }
}
