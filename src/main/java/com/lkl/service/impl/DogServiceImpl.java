package com.lkl.service.impl;

import com.lkl.dao.DogDao;
import com.lkl.dao.impl.DogDaoImpl;
import com.lkl.entity.Dog;
import com.lkl.service.DogService;

import java.util.List;

public class DogServiceImpl implements DogService {
    DogDao dogDao = new DogDaoImpl();

    @Override
    public Dog get(int did) {
        return dogDao.selectById(did);
    }

    @Override
    public List<Dog> getAll() {
        return dogDao.selectAll();
    }

    @Override
    public void add(Dog dog) {
        dogDao.insert(dog);
    }

    @Override
    public void remove(int did) {
        dogDao.delete(did);
    }

    @Override
    public void edit(Dog dog) {
        dogDao.update(dog);
    }

    /**
     * 获得所有记录数
     * @return
     */
    @Override
    public int getCount() {
        return dogDao.getCount();
    }

    /**
     *根据分页查询并返回数据集合
     * @param curPage
     * @param pageSize
     * @return
     */
    @Override
    public List<Dog> getPage(int curPage, int pageSize) {
        return dogDao.selectByPage(curPage,pageSize);
    }

    @Override
    public boolean isNameNotExist(String name) {
        return dogDao.isNameNotExist(name);
    }
}
