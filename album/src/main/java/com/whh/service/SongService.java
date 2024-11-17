package com.whh.service;

import com.whh.domain.PageBean;
import com.whh.domain.Song;
import com.whh.domain.SongDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SongService {
    /**
     * 分页查询
     * @param current
     * @param pageSize
     * @param selectImfor
     * @return
     */
    public PageBean<SongDetails> selectSongBypageAndCondition(int current, int pageSize, String selectImfor);

    /**
     * 根据歌手id查询
     * @param id
     * @return
     */
    public List<SongDetails> selectBySingerId(int id);

    /**
     * 根据专辑id查询
     * @param id
     * @return
     */
    public List<SongDetails> selectByAlbumId(int id);

    /**
     * 根据歌曲id查询
     * @param id
     * @return
     */
    public SongDetails selectSongById(int id);


    /**
     * 查询所有
     * @return
     */
    public List<SongDetails> selectAll();

    /**
     * 根据歌曲id数组查询歌曲
     * @param ids
     * @return
     */
    public List<SongDetails> selectByIds(int[] ids);

    /**
     * 新增歌曲
     * @param song
     * @return
     */
    public boolean add(Song song);


    /**
     * 根据id删除
     * @param id
     * @return
     */
    public boolean deleteByChoose(int id);

    /**
     * 根据歌曲数组删除
     * @param ids
     * @return
     */
    public boolean deleteByIds(int[] ids);


    /**
     * 修改歌曲数据
     * @param song
     * @return
     */
    public boolean update(Song song);
}
