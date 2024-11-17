package com.whh.service.impl;

import com.whh.dao.SingerDao;
import com.whh.domain.PageBean;
import com.whh.domain.Singer;
import com.whh.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerDao singerDao;

    @Override
    public PageBean<Singer> selectSingerBypageAndCondition(int current, int pageSize, String selectImfor) {
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
        List<Singer> rows = singerDao.selectSingerBypageAndCondition(begin, size, selectImfor);
        //查询条目数
        int totalCount = singerDao.selectTotalCountByCondition(selectImfor);

        PageBean<Singer> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        return pageBean;
    }

    @Override
    public Singer selectById(int id) {
        return singerDao.selectById(id);
    }

    @Override
    public boolean add(Singer singer) {
        return singerDao.add(singer)>0;
    }

    @Override
    public boolean deleteByChoose(int id) {
        return singerDao.deleteByChoose(id)>0;
    }

    @Override
    public boolean deleteByIds(int[] ids) {
        return singerDao.deleteByIds(ids)>0;
    }

    @Override
    public boolean update(Singer singer) {
        return singerDao.update(singer)>0;
    }
}
