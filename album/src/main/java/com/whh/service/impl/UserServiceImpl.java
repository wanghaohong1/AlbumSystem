package com.whh.service.impl;

import com.whh.dao.UserDao;
import com.whh.domain.PageBean;
import com.whh.domain.User;
import com.whh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageBean<User> selectByPageAndCondition(int current, int pageSize, String selectImfor) {
        if(selectImfor.equals("null")){
            selectImfor = "";
        }
        if(selectImfor != null && selectImfor.length()>0){
            selectImfor = "%"+selectImfor+"%";
        }
        //计算开始索引
        int begin = (current-1)*pageSize;
        //计算查询条目数
        int size = pageSize;
        List<User> rows = userDao.selectByPageAndCondition(begin, size, selectImfor);
        //查询条目数
        int totalCount = userDao.selectTotalCountByCondition(selectImfor);

        PageBean<User> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        return pageBean;
    }

    @Override
    public User selectUser(String username, String password) {
        return userDao.selectUser(username, password);
    }

    @Override
    public User selectById(int id) {
        return userDao.selectById(id);
    }



    @Override
    public User selectByUserName(String username) {
        return userDao.selectByUserName(username);
    }

    @Override
    public boolean add(User user) {
        return userDao.add(user)>0;
    }

    @Override
    public boolean manageadd(User user) {
        return userDao.manageadd(user)>0;
    }

    @Override
    public boolean deleteByChoose(int id) {
        return userDao.deleteByChoose(id)>0;
    }

    @Override
    public boolean deleteByIds(int[] ids) {
        return userDao.deleteByIds(ids)>0;
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user)>0;
    }
}
