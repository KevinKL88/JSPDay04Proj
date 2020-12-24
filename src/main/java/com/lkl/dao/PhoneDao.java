package com.lkl.dao;

import com.lkl.entity.Phone;

import java.util.List;

public interface PhoneDao {
    Phone selectById(int pid);

    List<Phone> selectAll();

    void insert(Phone phone);

    void delete(int pid);

    void update(Phone phone);

    int getCount();

    List<Phone> selectByPage(int curPage, int pageSize);

    boolean isModelNotExist(String pmodel);
}
