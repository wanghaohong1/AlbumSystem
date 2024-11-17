package com.whh.service.impl;

import com.whh.dao.CommentDao;
import com.whh.dao.SingerDao;
import com.whh.domain.Comment;
import com.whh.domain.CommentView;
import com.whh.domain.PageBean;
import com.whh.domain.Singer;
import com.whh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public PageBean<CommentView> selectCommentBypageAndCondition(int current, int pageSize, String selectImfor) {
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
        List<CommentView> rows = commentDao.selectCommentBypageAndCondition(begin, size, selectImfor);
        //查询条目数
        int totalCount = commentDao.selectTotalCountByCondition(selectImfor);

        PageBean<CommentView> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        return pageBean;
    }

    @Override
    public List<CommentView> selectByUserId(int id) {
        return commentDao.selectByUserId(id);
    }

    @Override
    public boolean addComment(Comment comment) {
        return commentDao.addComment(comment)>0;
    }

    @Override
    public boolean deleteComment(int id) {
        return commentDao.deleteComment(id)>0;
    }

    @Override
    public boolean deleteByIds(int[] ids) {
        return commentDao.deleteByIds(ids)>0;
    }

    @Override
    public boolean update(Comment comment) {
        return commentDao.update(comment)>0;
    }
}
