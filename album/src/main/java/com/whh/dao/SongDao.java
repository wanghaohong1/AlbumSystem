package com.whh.dao;

import com.whh.domain.CommentView;
import com.whh.domain.Song;
import com.whh.domain.SongDetails;
import com.whh.domain.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SongDao {
    //按页码查询，提供查询索引和一次查询多少数据两个参数
    //条件分页查询
    List<SongDetails> selectSongBypageAndCondition(@Param("begin")int begin, @Param("size")int size, @Param("selectImfor")String selectImfor);

    //查询总记录数
    int selectTotalCountByCondition(@Param("selectImfor") String selectImfor);

    List<SongDetails> selectBySingerId(int id);

    List<SongDetails> selectByAlbumId(int id);

    SongDetails selectSongById(int id);

    //查询全部
    List<SongDetails> selectAll();

    //根据歌曲id数组查询
    List<SongDetails> selectByIds(@Param("ids") int[] ids);

    int selectTotalCountByUserId(int id);


    @Insert("INSERT into tb_song values (null, #{son_name}, #{duration}, #{alb_id})")
    int add(Song song);

    //删除数据，选中某个数据，获得其id，然后删掉
    @Delete("delete from tb_song where son_id=#{id}")
    int deleteByChoose(int id);

    int update(Song song);

    int deleteByIds(@Param("ids") int[] ids);
}
