package com.lkl.dao;

import com.lkl.entity.Dog;

import java.util.List;

public interface DogDao {
    Dog selectById(int did);

    List<Dog> selectAll();

    void insert(Dog dog);

    void delete(int did);

    void update(Dog dog);

    int getCount();

    List<Dog> selectByPage(int curPage,int pageSize);

    boolean isNameNotExist(String name);
}
