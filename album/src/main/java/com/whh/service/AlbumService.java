package com.whh.service;

import com.whh.domain.Album;
import com.whh.domain.AlbumDetails;
import com.whh.domain.PageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AlbumService {
    /**
     * 分页查询
     * @param current
     * @param pageSize
     * @param selectImfor
     * @return
     */
    public PageBean<AlbumDetails> selectAlbumBypageAndCondition(int current, int pageSize, String selectImfor);

    /**
     * 按id查询
     * @param id
     * @return
     */
    public AlbumDetails selectById(Integer id);

    /**
     * 根据歌手id查询
     * @param id
     * @return
     */
    public List<AlbumDetails> selectBySingerId(int id);

    /**
     * 新增专辑
     * @param album
     * @return
     */
    public boolean add(Album album);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public boolean deleteByChoose(int id);

    /**
     * 根据id数组删除
     * @param ids
     * @return
     */
    public boolean deleteByIds(int[] ids);

    /**
     * 修改专辑数据
     * @param album
     * @return
     */
    public boolean update(Album album);

    /**
     * 修改专辑剩余数量
     * @param number
     * @return
     */
    public boolean updateNumber(int aId, int number);
}
