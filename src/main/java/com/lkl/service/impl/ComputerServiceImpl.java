package com.lkl.service.impl;


import com.lkl.dao.ComputerDao;
import com.lkl.dao.impl.ComputerDaoImpl;
import com.lkl.entity.Computer;
import com.lkl.service.ComputerService;

import java.util.List;

/**
 * 业务层
 */
public class ComputerServiceImpl implements ComputerService {
    ComputerDao computerDao = new ComputerDaoImpl();

    /**
     * 添加
     * @param computer
     */
    @Override
    public void add(Computer computer) {
        computerDao.addComputer(computer);
    }

    /**
     * 修改
     * @param computer
     */
    @Override
    public void edit(Computer computer) {
        computerDao.updateComputer(computer);
    }

    /**
     * 删除
     * @param cid
     */
    @Override
    public void remove(int cid) {
        computerDao.deleteComputerById(cid);
    }

    /**
     * 根据id查找
     * @param cid
     * @return
     */
    @Override
    public Computer get(int cid) {
        return computerDao.selectComputerById(cid);
    }

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<Computer> getAll() {
        return computerDao.selectAll();
    }

    @Override
    public int getCount() {
        return computerDao.getCount();
    }

    @Override
    public List<Computer> getPage(int curPage, int pageSize) {
        return computerDao.selectByPage(curPage, pageSize);
    }

    @Override
    public boolean isModelNotExist(String cmodel) {
        return computerDao.isModelNotExist(cmodel);
    }
}
