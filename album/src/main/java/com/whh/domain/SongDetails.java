package com.whh.domain;

import org.apache.ibatis.type.Alias;

@Alias("SongDetails")
public class SongDetails {
    private int son_id;
    private String son_name;
    private String duration;
    private int alb_id;
    private int sin_id;
    private String alb_name;
    private String sin_name;

    public int getSon_id() {
        return son_id;
    }

    public void setSon_id(int son_id) {
        this.son_id = son_id;
    }

    public String getSon_name() {
        return son_name;
    }

    public void setSon_name(String son_name) {
        this.son_name = son_name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getAlb_id() {
        return alb_id;
    }

    public void setAlb_id(int alb_id) {
        this.alb_id = alb_id;
    }

    public int getSin_id() {
        return sin_id;
    }

    public void setSin_id(int sin_id) {
        this.sin_id = sin_id;
    }

    public String getAlb_name() {
        return alb_name;
    }

    public void setAlb_name(String alb_name) {
        this.alb_name = alb_name;
    }

    public String getSin_name() {
        return sin_name;
    }

    public void setSin_name(String sin_name) {
        this.sin_name = sin_name;
    }

    @Override
    public String toString() {
        return "SongDetails{" +
                "son_id=" + son_id +
                ", son_name='" + son_name + '\'' +
                ", duration='" + duration + '\'' +
                ", alb_id=" + alb_id +
                ", sin_id=" + sin_id +
                ", alb_name='" + alb_name + '\'' +
                ", sin_name='" + sin_name + '\'' +
                '}';
    }
}
