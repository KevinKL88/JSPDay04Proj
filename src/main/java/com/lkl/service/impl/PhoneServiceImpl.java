package com.lkl.service.impl;

import com.lkl.dao.PhoneDao;
import com.lkl.dao.impl.PhoneDaoImpl;
import com.lkl.entity.Phone;
import com.lkl.service.PhoneService;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {
    PhoneDao phoneDao = new PhoneDaoImpl();

    @Override
    public Phone get(int pid) {
        return phoneDao.selectById(pid);
    }

    @Override
    public List<Phone> getAll() {
        return phoneDao.selectAll();
    }

    @Override
    public void add(Phone phone) {
        phoneDao.insert(phone);
    }

    @Override
    public void remove(int pid) {
        phoneDao.delete(pid);
    }

    @Override
    public void edit(Phone phone) {
        phoneDao.update(phone);
    }

    @Override
    public int getCount() {
        return phoneDao.getCount();
    }

    @Override
    public boolean isModelNotExist(String pmodel) {
        return phoneDao.isModelNotExist(pmodel);
    }

    @Override
    public List<Phone> getPage(int curPage, int pageSize) {
        return phoneDao.selectByPage(curPage,pageSize);
    }
}
