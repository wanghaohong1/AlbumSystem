package com.whh.service;

import com.whh.domain.Comment;
import com.whh.domain.CommentView;
import com.whh.domain.PageBean;

import java.util.List;

public interface CommentService {
    /**
     * 查询评论视图
     * @param current
     * @param pageSize
     * @param selectImfor
     * @return
     */
    public PageBean<CommentView> selectCommentBypageAndCondition(int current, int pageSize, String selectImfor);

    public List<CommentView> selectByUserId(int id);

    public boolean addComment(Comment comment);

    public boolean deleteComment(int id);

    public boolean deleteByIds(int[] ids);

    public boolean update(Comment comment);
}
