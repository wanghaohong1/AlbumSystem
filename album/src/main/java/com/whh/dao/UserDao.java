package com.whh.dao;

import com.whh.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> selectByPageAndCondition(@Param("begin")int begin, @Param("size")int size, @Param("selectImfor")String selectImfor);

    int selectTotalCountByCondition(@Param("selectImfor") String selectImfor);

    User selectById(int id);

    User selectUser(@Param("username") String username,@Param("password") String password);

    User selectByUserName(@Param("username")String username);

    int add(User user);

    int manageadd(User user);

    int update(User user);

    @Delete("delete from tb_user where user_id=#{id}")
    int deleteByChoose(int id);

    int deleteByIds(@Param("ids") int[] ids);
}
