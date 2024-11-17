package com.whh.domain;

import org.apache.ibatis.type.Alias;

@Alias("PurchaseView")
public class PurchaseView {
    private int user_id;
    private int alb_id;
    private String pur_order;
    private int pur_number;
    private String pur_time;
    private String alb_name;
    private String price;
    private String username;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAlb_id() {
        return alb_id;
    }

    public void setAlb_id(int alb_id) {
        this.alb_id = alb_id;
    }

    public String getPur_order() {
        return pur_order;
    }

    public void setPur_order(String pur_order) {
        this.pur_order = pur_order;
    }

    public int getPur_number() {
        return pur_number;
    }

    public void setPur_number(int pur_number) {
        this.pur_number = pur_number;
    }

    public String getPur_time() {
        return pur_time;
    }

    public void setPur_time(String pur_time) {
        this.pur_time = pur_time;
    }

    public String getAlb_name() {
        return alb_name;
    }

    public void setAlb_name(String alb_name) {
        this.alb_name = alb_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "PurchaseView{" +
                "user_id=" + user_id +
                ", alb_id=" + alb_id +
                ", pur_order=" + pur_order +
                ", pur_number=" + pur_number +
                ", pur_time='" + pur_time + '\'' +
                ", alb_name='" + alb_name + '\'' +
                ", price='" + price + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
