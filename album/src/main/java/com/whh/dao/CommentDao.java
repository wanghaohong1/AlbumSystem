package com.whh.dao;

import com.whh.domain.Comment;
import com.whh.domain.CommentView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentDao {
    List<CommentView> selectCommentBypageAndCondition(@Param("begin")int begin, @Param("size")int size, @Param("selectImfor")String selectImfor);

    int selectTotalCountByCondition(@Param("selectImfor") String selectImfor);

    List<CommentView> selectByUserId(@Param("id") int id);
    int addComment(Comment comment);
    int deleteComment(@Param("id") int id);

    int deleteByIds(@Param("ids") int[] ids);

    int update(Comment comment);
}
