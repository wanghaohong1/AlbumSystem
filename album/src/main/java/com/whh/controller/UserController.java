package com.whh.controller;

import com.whh.domain.PageBean;
import com.whh.domain.User;
import com.whh.service.UserService;
import com.whh.util.CheckCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/selectAll/{current}/{pageSize}/{selectImfor}")
    public Result getAll(@PathVariable Integer current, @PathVariable Integer pageSize, @PathVariable String selectImfor){
        //方法逻辑
        PageBean<User> pageBean = userService.selectByPageAndCondition(current, pageSize, selectImfor);
        Integer code = pageBean != null ? Code.GET_OK : Code.GET_ERR;
        String msg = pageBean != null ? "" : "数据查询失败，请重试！";
        return new Result(code, pageBean, msg);
    }


    @GetMapping("/id/{id}")
    public Result getById(@PathVariable int id){
        User user = userService.selectById(id);
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "数据查询失败，请重试！";
        return new Result(code, user, msg);
    }

    @GetMapping("/userId")
    public Result getMy(HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("user");
        User user = userService.selectById(u.getUser_id());
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "数据查询失败，请重试！";
        return new Result(code, user, msg);
    }

    @GetMapping("/user/{username}")
    public Result getByUsername(@PathVariable String username){
        User user = userService.selectByUserName(username);
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "数据查询失败，请重试！";
        return new Result(code, user, msg);
    }

    @PostMapping
    public Result add(@RequestBody User user){
        boolean flag = userService.add(user);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PostMapping("/manage")
    public Result manageadd(@RequestBody User user){
        boolean flag = userService.manageadd(user);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR, flag);
    }

    @DeleteMapping("/id/{id}")
    public Result deleteByChoose(@PathVariable Integer id){
        boolean flag = userService.deleteByChoose(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR, flag);
    }

    @DeleteMapping("/ids/{ids}")
    public Result deleteByIds(@PathVariable int[] ids){
        boolean flag = userService.deleteByIds(ids);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody User user){
        boolean flag = userService.update(user);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR, flag);
    }

    @GetMapping("/checkCodeServlet")
    public void checkCodeServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 生成验证码
        ServletOutputStream os = response.getOutputStream();
        String checkCode = CheckCodeUtil.outputVerifyImage(100, 40, os, 4);

        //存入验证码
        HttpSession session = request.getSession();
        session.setAttribute("checkCodeGen", checkCode);
    }

    @GetMapping("/register/{checkCode}")
    public Result register(@PathVariable String checkCode, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //程序自己的验证码，从session获取
        HttpSession session = request.getSession();
        String checkCodeGen = (String)session.getAttribute("checkCodeGen");
        //比对
        if(!checkCode.equalsIgnoreCase(checkCodeGen)){
            return new Result(Code.GET_ERR, checkCodeGen, "验证码错误！");
        }else{
            return new Result(Code.GET_OK, checkCodeGen, "验证码正确！");
        }
    }
}
