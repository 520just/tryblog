package com.jian.entity;

import java.util.Date;

/**
 * @program: myblog
 * @description:
 * @author: 520just
 * @create: 2021-08-21 11:23
 **/
public class Friend {
    private int id;
    private String name;
    private String url;
    private String picture;
    private Date createTime;

    public Friend() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", picture='" + picture + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
