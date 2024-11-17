package com.whh.service;

import com.whh.domain.PageBean;
import com.whh.domain.Singer;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SingerService {
    /**
     * 分页查询
     * @param current
     * @param pageSize
     * @param selectImfor
     * @return
     */
    public PageBean<Singer> selectSingerBypageAndCondition(int current, int pageSize, String selectImfor);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Singer selectById(int id);

    /**
     * 新增歌手
     * @param singer
     * @return
     */
    public boolean add(Singer singer);

    /**
     * 根据歌手id删除
     * @param id
     * @return
     */
    public boolean deleteByChoose(int id);

    /**
     * 根据歌手id数组删除
     * @param ids
     * @return
     */
    public boolean deleteByIds(int[] ids);

    /**
     * 修改歌手
     * @param singer
     * @return
     */
    public boolean update(Singer singer);
}
