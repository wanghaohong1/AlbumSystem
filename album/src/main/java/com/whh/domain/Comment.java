package com.whh.domain;

import org.apache.ibatis.type.Alias;

@Alias("Comment")
public class Comment {
    private int com_id;
    private int score;
    private String com_time;
    private String content;
    private int user_id;
    private int alb_id;

    public int getCom_id() {
        return com_id;
    }

    public void setCom_id(int com_id) {
        this.com_id = com_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCom_time() {
        return com_time;
    }

    public void setCom_time(String com_time) {
        this.com_time = com_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    @Override
    public String toString() {
        return "Comment{" +
                "com_id=" + com_id +
                ", score=" + score +
                ", com_time='" + com_time + '\'' +
                ", content='" + content + '\'' +
                ", user_id=" + user_id +
                ", alb_id=" + alb_id +
                '}';
    }
}
