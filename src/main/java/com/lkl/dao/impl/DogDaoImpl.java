package com.lkl.dao.impl;

import com.lkl.dao.DogDao;
import com.lkl.entity.Dog;
import com.lkl.entity.Phone;
import com.lkl.entity.User;
import com.lkl.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogDaoImpl implements DogDao {
    @Override
    public Dog selectById(int did) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Dog dog = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from Dog where did=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,did);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                dog = new Dog();
                dog.setDid(rs.getInt("did"));
                dog.setDname(rs.getString("d_name"));
                dog.setDspecies(rs.getString("d_species"));
                dog.setAge(rs.getInt("d_age"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return dog;
    }

    @Override
    public List<Dog> selectAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Dog> dogList = new ArrayList<Dog>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from Dog";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Dog dog = new Dog();
                dog.setDid(rs.getInt("did"));
                dog.setDname(rs.getString("d_name"));
                dog.setDspecies(rs.getString("d_species"));
                dog.setAge(rs.getInt("d_age"));

                dogList.add(dog);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return dogList;
    }

    /**
     * 新增Dog
     * @param dog
     */
    @Override
    public void insert(Dog dog) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into dog values (null,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,dog.getDname());
            pstmt.setString(2,dog.getDspecies());
            pstmt.setInt(3,dog.getAge());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
    }

    /**
     * 删除Dog
     * @param did
     */
    @Override
    public void delete(int did) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from dog where did=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,did);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
    }

    @Override
    public void update(Dog dog) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update dog set d_name=?,d_species=?,d_age=? where did=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,dog.getDname());
            pstmt.setString(2,dog.getDspecies());
            pstmt.setInt(3,dog.getAge());
            pstmt.setInt(4,dog.getDid());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
    }

    /**
     * 获得所有记录数
     * @return
     */
    @Override
    public int getCount() {
        int count = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select count(*) from dog";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            rs.next();
            //获得结果集的第一列数据，即Count（*）
            count = rs.getInt(1);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
        return count;
    }

    /**
     * 根据分页查询并返回数据集合
     * @param curPage
     * @param pageSize
     * @return
     */
    @Override
    public List<Dog> selectByPage(int curPage,int pageSize) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Dog> list = new ArrayList<Dog>();
        try {
            conn = JDBCUtils.getConnection();
            //limit x,y--》x：起始下标，从0开始，y：要查多少条数据
            String sql = "select * from dog limit ?,?";
            pstmt = conn.prepareStatement(sql);
            //起始下标，（当前页号-1）*页面大小
            int begin = (curPage-1)*pageSize;
            pstmt.setInt(1, begin);
            pstmt.setInt(2,pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Dog dog = new Dog();
                dog.setDid(rs.getInt("did"));
                dog.setDname(rs.getString("d_name"));
                dog.setDspecies(rs.getString("d_species"));
                dog.setAge(rs.getInt("d_age"));

                list.add(dog);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return list;
    }

    @Override
    public boolean isNameNotExist(String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //dname是够存在的标志，true表示不存在，false表示存在
        boolean flag = true;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select d_name from dog";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("d_name").equals(name)) {
                    //如果存在相同dname，则将flag置为false
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
