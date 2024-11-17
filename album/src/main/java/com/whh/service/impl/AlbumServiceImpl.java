package com.whh.service.impl;

import com.whh.dao.AlbumDao;
import com.whh.domain.Album;
import com.whh.domain.AlbumDetails;
import com.whh.domain.PageBean;
import com.whh.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;

    @Override
    public PageBean<AlbumDetails> selectAlbumBypageAndCondition(int current, int pageSize, String selectImfor) {
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
        List<AlbumDetails> rows = albumDao.selectAlbumBypageAndCondition(begin, size, selectImfor);
        //查询总记录数
        int totalCount = albumDao.selectTotalCountByCondition(selectImfor);

        PageBean<AlbumDetails> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        return pageBean;
    }

    @Override
    public AlbumDetails selectById(Integer id){
        return albumDao.selectById(id);
    }

    @Override
    public List<AlbumDetails> selectBySingerId(int id) {
        return albumDao.selectBySingerId(id);
    }

    @Override
    public boolean add(Album album) {
        return albumDao.add(album)>0;
    }

    @Override
    public boolean deleteByChoose(int id) {
        return albumDao.deleteByChoose(id)>0;
    }

    @Override
    public boolean deleteByIds(int[] ids) {
        return albumDao.deleteByIds(ids)>0;
    }

    @Override
    public boolean update(Album album) {
        return albumDao.update(album)>0;
    }

    @Override
    public boolean updateNumber(int aId, int number) {
        System.out.println(aId+"/"+number);
        return albumDao.updateNumber(aId, number)>0;
    }
}
