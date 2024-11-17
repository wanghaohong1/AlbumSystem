package com.whh.domain;

import org.apache.ibatis.type.Alias;

@Alias("Song")
public class Song {
    private int son_id;
    private String son_name;
    private String duration;
    private int alb_id;

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

    @Override
    public String toString() {
        return "Song{" +
                "son_id=" + son_id +
                ", son_name='" + son_name + '\'' +
                ", duration='" + duration + '\'' +
                ", alb_id=" + alb_id +
                '}';
    }
}
