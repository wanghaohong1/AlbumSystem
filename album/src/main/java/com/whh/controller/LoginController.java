package com.whh.controller;

import com.whh.domain.User;
import com.whh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}/{password}/{remember}/{value}")
    public Result getByUP(@PathVariable String username, @PathVariable String password, @PathVariable String remember, @PathVariable String value, HttpServletRequest request, HttpServletResponse response){
        User user = userService.selectUser(username, password);
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "账号或密码错误，请重试！";
        if(user != null){
            if(Objects.equals(remember, "true")){
                //说明用户勾选了，发送cookie
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);
                Cookie c_remember = new Cookie("remember", remember);
                Cookie c_value = new Cookie("value", value);
                c_username.setPath("/"); // 设置cookie的路径为应用的上下文路径
                c_password.setPath("/"); // 设置cookie的路径为应用的上下文路径
                c_remember.setPath("/");
                c_value.setPath("/");
                c_username.setMaxAge(60 * 60);
                c_password.setMaxAge(60 * 60);
                c_remember.setMaxAge(60*60);
                c_value.setMaxAge(60*60);
                response.addCookie(c_username);
                response.addCookie(c_password);
                response.addCookie(c_remember);
                response.addCookie(c_value);
            }
            //将登录成功后的user对象，存储到session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }
        return new Result(code, user, msg);
    }

    @GetMapping("/getSession")
    public Result getSession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return new Result(Code.GET_ERR, user, "fail");
        }else{
            return new Result(Code.GET_OK, user, "success");
        }
    }

    @GetMapping("/quit")
    public Result quit(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) request.getSession().getAttribute("user");
        session.removeAttribute("user");
        return new Result(Code.GET_OK, user, "success");
    }
}
