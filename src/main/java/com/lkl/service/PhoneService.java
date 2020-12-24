package com.lkl.service;

import com.lkl.entity.Phone;

import java.util.List;

public interface PhoneService {
    Phone get(int id);

    List<Phone> getAll();

    void add(Phone phone);

    void remove(int pid);

    void edit(Phone phone);

    int getCount();

    List<Phone> getPage(int curPage, int pageSize);

    boolean isModelNotExist(String pmodel);
}
