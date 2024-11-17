package com.whh.domain;

import org.apache.ibatis.type.Alias;

@Alias("AlbumDetails")
public class AlbumDetails {
    private Integer alb_id;
    private String alb_name;
    private String price;
    private String style;
    private Integer sin_number;
    private String alb_time;
    private String company;
    private String language;
    private String medium;
    private String summary;
    private String number;
    private Integer sin_id;
    private String sin_name;

    public Integer getAlb_id() {
        return alb_id;
    }

    public void setAlb_id(Integer alb_id) {
        this.alb_id = alb_id;
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Integer getSin_number() {
        return sin_number;
    }

    public void setSin_number(Integer sin_number) {
        this.sin_number = sin_number;
    }

    public String getAlb_time() {
        return alb_time;
    }

    public void setAlb_time(String alb_time) {
        this.alb_time = alb_time;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getSin_id() {
        return sin_id;
    }

    public void setSin_id(Integer sin_id) {
        this.sin_id = sin_id;
    }

    public String getSin_name() {
        return sin_name;
    }

    public void setSin_name(String sin_name) {
        this.sin_name = sin_name;
    }

    @Override
    public String toString() {
        return "AlbumDetails{" +
                "alb_id=" + alb_id +
                ", alb_name='" + alb_name + '\'' +
                ", price='" + price + '\'' +
                ", style='" + style + '\'' +
                ", sin_number=" + sin_number +
                ", alb_time='" + alb_time + '\'' +
                ", company='" + company + '\'' +
                ", language='" + language + '\'' +
                ", medium='" + medium + '\'' +
                ", summary='" + summary + '\'' +
                ", number='" + number + '\'' +
                ", sin_id=" + sin_id +
                ", sin_name='" + sin_name + '\'' +
                '}';
    }
}
