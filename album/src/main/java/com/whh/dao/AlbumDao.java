package com.whh.dao;

import com.whh.domain.Album;
import com.whh.domain.AlbumDetails;
import org.apache.ibatis.annotations.*;

import java.util.List;

// TODO 添加@Mapper,让springboot扫描到，进行自动代理
@Mapper
public interface AlbumDao {
    //按页码查询，提供查询索引和一次查询多少数据两个参数
    public List<AlbumDetails> selectAlbumBypageAndCondition(int begin, int size, String selectImfor);
    //总体数据量查询
    //查询总体记录数
    @Select("select count(*) from singer_album_view")
    public int setTotalCount();

    public int selectTotalCountByCondition(String selectImfor);

    public AlbumDetails selectById(int id);

    public List<AlbumDetails> selectBySingerId(int id);

    @Insert("INSERT into tb_album values (null, #{alb_name},#{price},#{style},#{sin_number},#{alb_time},#{company},#{language},#{medium}, #{summary}, #{number}, #{sin_id})")
    public int add(Album album);

    @Delete("delete from tb_album where alb_id=#{id}")
    public int deleteByChoose(int id);

    public int update(Album album);

    public int deleteByIds(@Param("ids") int[] ids);

    public int updateNumber(@Param("aId") int aId, @Param("number") int number);
}
