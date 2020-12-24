package com.lkl.service;

import com.lkl.entity.Dog;

import java.util.List;

public interface DogService {
    Dog get(int did);

    List<Dog> getAll();

    void add(Dog dog);

    void remove(int did);

    void edit(Dog dog);

    int getCount();

    List<Dog> getPage(int curPage, int pageSize);

    boolean isNameNotExist(String name);
}
