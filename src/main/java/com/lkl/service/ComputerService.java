package com.lkl.service;

import com.lkl.entity.Computer;
import com.lkl.entity.Phone;

import java.util.List;

public interface ComputerService {
    void add(Computer computer);

    void edit(Computer computer);

    void remove(int cid);

    Computer get(int cid);

    List<Computer> getAll();

    int getCount();

    List<Computer> getPage(int curPage, int pageSize);

    boolean isModelNotExist(String cmodel);
}
