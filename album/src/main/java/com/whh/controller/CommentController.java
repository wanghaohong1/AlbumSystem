package com.whh.controller;

import com.whh.domain.Comment;
import com.whh.domain.CommentView;
import com.whh.domain.PageBean;
import com.whh.domain.User;
import com.whh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/selectAll/{current}/{pageSize}/{selectImfor}")
    public Result getAll(@PathVariable Integer current, @PathVariable Integer pageSize,
                         @PathVariable(required = false) String selectImfor){
        PageBean<CommentView> pageBean = commentService.selectCommentBypageAndCondition(current, pageSize, selectImfor);
        Integer code = pageBean != null ? Code.GET_OK : Code.GET_ERR;
        String msg = pageBean != null ? "" : "数据查询失败，请重试！";
        return new Result(code, pageBean, msg);
    }

    @GetMapping("/user/{id}")
    public Result getByUserId(@PathVariable int id){
        List<CommentView> commentViewList = commentService.selectByUserId(id);
        Integer code = commentViewList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = commentViewList != null ? "" : "数据查询失败，请重试！";
        return new Result(code, commentViewList, msg);
    }

    @PostMapping
    public Result addComment(@RequestBody Comment comment){
        boolean flag = commentService.addComment(comment);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR, flag);
    }

    @PostMapping("/user")
    public Result UseraddComment(@RequestBody Comment comment, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        comment.setUser_id(user.getUser_id());
        boolean flag = commentService.addComment(comment);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR, flag);
    }

    @DeleteMapping("/id/{id}")
    public Result deleteByChoose(@PathVariable Integer id){
        boolean flag = commentService.deleteComment(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR, flag);
    }

    @DeleteMapping("/ids/{ids}")
    public Result deleteByIds(@PathVariable int[] ids){
        boolean flag = commentService.deleteByIds(ids);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Comment comment){
        boolean flag = commentService.update(comment);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR, flag);
    }
}
