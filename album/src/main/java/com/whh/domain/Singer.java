package com.whh.domain;

import org.apache.ibatis.type.Alias;

@Alias("singer")
public class Singer {
    private int sin_id;
    private String sin_name;
    private String masterpiece;
    private String fans;

    public int getSin_id() {
        return sin_id;
    }

    public void setSin_id(int sin_id) {
        this.sin_id = sin_id;
    }

    public String getSin_name() {
        return sin_name;
    }

    public void setSin_name(String sin_name) {
        this.sin_name = sin_name;
    }

    public String getMasterpiece() {
        return masterpiece;
    }

    public void setMasterpiece(String masterpiece) {
        this.masterpiece = masterpiece;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "sin_id=" + sin_id +
                ", sin_name='" + sin_name + '\'' +
                ", masterpiece='" + masterpiece + '\'' +
                ", fans='" + fans + '\'' +
                '}';
    }
}
