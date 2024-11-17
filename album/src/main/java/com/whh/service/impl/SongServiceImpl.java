package com.whh.service.impl;

import com.whh.dao.SongDao;
import com.whh.domain.PageBean;
import com.whh.domain.Song;
import com.whh.domain.SongDetails;
import com.whh.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongDao songDao;


    @Override
    public PageBean<SongDetails> selectSongBypageAndCondition(int current, int pageSize, String selectImfor) {
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
        List<SongDetails> rows = songDao.selectSongBypageAndCondition(begin, size, selectImfor);
        //查询条目数
        int totalCount = songDao.selectTotalCountByCondition(selectImfor);
        //去掉歌曲时长里时分秒的时"00:"
        for (SongDetails song : rows) {
            String duration = song.getDuration();
            if (duration != null && duration.length() > 5) {
                song.setDuration(duration.substring(3));
            }
        }
        PageBean<SongDetails> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        return pageBean;
    }

    @Override
    public List<SongDetails> selectBySingerId(int id) {
        List<SongDetails> songDetailsList = songDao.selectBySingerId(id);
        for (SongDetails song : songDetailsList) {
            String duration = song.getDuration();
            if (duration != null && duration.length() > 5) {
                song.setDuration(duration.substring(3));
            }
        }
        return songDetailsList;
    }

    @Override
    public List<SongDetails> selectByAlbumId(int id) {
        List<SongDetails> songDetailsList = songDao.selectByAlbumId(id);
        for (SongDetails song : songDetailsList) {
            String duration = song.getDuration();
            if (duration != null && duration.length() > 5) {
                song.setDuration(duration.substring(3));
            }
        }
        return songDetailsList;
    }

    @Override
    public SongDetails selectSongById(int id) {
        return songDao.selectSongById(id);
    }

    @Override
    public List<SongDetails> selectAll() {
        return songDao.selectAll();
    }

    @Override
    public List<SongDetails> selectByIds(int[] ids) {
        return songDao.selectByIds(ids);
    }

    @Override
    public boolean add(Song song) {
        return songDao.add(song)>0;
    }

    @Override
    public boolean deleteByChoose(int id) {
        return songDao.deleteByChoose(id)>0;
    }

    @Override
    public boolean deleteByIds(int[] ids) {
        return songDao.deleteByIds(ids)>0;
    }


    @Override
    public boolean update(Song song) {
        return songDao.update(song)>0;
    }
}
