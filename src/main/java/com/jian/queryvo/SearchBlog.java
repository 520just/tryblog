package com.jian.queryvo;

import java.util.Date;

/**
 * @program: myblog
 * @description: 文章管理实体类
 * @author: 520just
 * @create: 2021-08-24 10:31
 **/
public class SearchBlog {

    private Long id;
    private String title;
    private String typeName;
    private boolean recommend;
    private boolean published;
    private Date updateTime;

    public SearchBlog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SearchBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", typeName='" + typeName + '\'' +
                ", recommend=" + recommend +
                ", published=" + published +
                ", updateTime=" + updateTime +
                '}';
    }
}
