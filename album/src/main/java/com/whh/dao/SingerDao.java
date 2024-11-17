package com.whh.dao;

import com.whh.domain.Singer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SingerDao {
    //分页查询
    List<Singer> selectSingerBypageAndCondition(@Param("begin")int begin, @Param("size")int size, @Param("selectImfor")String selectImfor);

    int selectTotalCountByCondition(@Param("selectImfor") String selectImfor);

    //根据id查询
    Singer selectById (int id);

    @Insert("INSERT into tb_singer values (null, #{sin_name}, #{masterpiece}, #{fans})")
    int add(Singer singer);

    int update(Singer singer);

    //删除数据，选中某个数据，获得其id，然后删掉
    @Delete("delete from tb_singer where sin_id=#{id}")
    int deleteByChoose(int id);

    int deleteByIds(@Param("ids") int[] ids);
}
