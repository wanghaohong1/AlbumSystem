package com.whh.domain;

import org.apache.ibatis.type.Alias;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@Alias("user")
public class User implements HttpSessionBindingListener {
    private Integer user_id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String sex;
    private String city;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public void valueBound(HttpSessionBindingEvent e){
        HttpSession session = e.getSession();
        session.getServletContext().log("用户名：" + username + ", 密码：" + password + ", 操作： 登录用户系统。");
    }
    public void valueUnbound(HttpSessionBindingEvent e){
        HttpSession session = e.getSession();
        session.getServletContext().log("用户：" + username + ", 密码：" + password + ", 操作：退出用户系统。");
    }
}
