package com.lkl.dao.impl;

import com.lkl.dao.PhoneDao;
import com.lkl.entity.Phone;
import com.lkl.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDaoImpl implements PhoneDao {

    @Override
    public int getCount() {
        int count = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select count(*) from phone";
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
    public List<Phone> selectByPage(int curPage, int pageSize) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Phone> list = new ArrayList<Phone>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from phone limit ?,?";
            pstmt = conn.prepareStatement(sql);
            int begin = (curPage-1)*pageSize;
            pstmt.setInt(1, begin);
            pstmt.setInt(2,pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Phone phone = new Phone();
                phone.setPid(rs.getInt("pid"));
                phone.setPbrand(rs.getString("p_brand"));
                phone.setPmodel(rs.getString("p_model"));
                phone.setPprice(rs.getDouble("p_price"));
                phone.setPsize(rs.getDouble("p_size"));

                list.add(phone);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return list;
    }

    @Override
    public boolean isModelNotExist(String pmodel) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //p_model是否存在的标志，true表示不存在，false表示存在
        boolean flag = true;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select p_model from phone";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("p_model").equals(pmodel)) {
                    //如果存在相同p_model，则将flag置为false
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

    @Override
    public Phone selectById(int pid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Phone phone = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from phone where pid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pid);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                phone = new Phone();
                phone.setPid(rs.getInt("pid"));
                phone.setPbrand(rs.getString("p_brand"));
                phone.setPmodel(rs.getString("p_model"));
                phone.setPprice(rs.getDouble("p_price"));
                phone.setPsize(rs.getDouble("p_size"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return phone;
    }

    @Override
    public List<Phone> selectAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Phone> phoneList = new ArrayList<Phone>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from phone";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Phone phone = new Phone();
                phone.setPid(rs.getInt("pid"));
                phone.setPbrand(rs.getString("p_brand"));
                phone.setPmodel(rs.getString("p_model"));
                phone.setPprice(rs.getDouble("p_price"));
                phone.setPsize(rs.getDouble("p_size"));

                phoneList.add(phone);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return phoneList;
    }

    /**
     * 添加方法
     * @param phone
     */
    @Override
    public void insert(Phone phone) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into phone values (null,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, phone.getPbrand());
            pstmt.setString(2, phone.getPmodel());
            pstmt.setDouble(3, phone.getPsize());
            pstmt.setDouble(4, phone.getPprice());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
    }

    /**
     * 删除方法
     * @param pid
     */
    @Override
    public void delete(int pid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from phone where pid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pid);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
    }

    /**
     * 修改方法
     * @param phone
     */
    @Override
    public void update(Phone phone) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update phone set p_brand=?,p_model=?,p_size=?,p_price=? where pid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, phone.getPbrand());
            pstmt.setString(2, phone.getPmodel());
            pstmt.setDouble(3, phone.getPsize());
            pstmt.setDouble(4, phone.getPprice());
            pstmt.setInt(5,phone.getPid());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
    }
}
