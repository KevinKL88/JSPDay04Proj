package com.lkl.dao;


import com.lkl.entity.Computer;

import java.util.List;

public interface ComputerDao {
    void addComputer(Computer computer);

    void updateComputer(Computer computer);

    void deleteComputerById(int cid);

    Computer selectComputerById(int cid);

    List<Computer> selectAll();

    int getCount();

    List<Computer> selectByPage(int curPage, int pageSize);

    boolean isModelNotExist(String cmodel);
}
