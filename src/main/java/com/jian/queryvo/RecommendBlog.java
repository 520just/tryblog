package com.jian.queryvo;

public class RecommendBlog {

    private Long id;
    private String title;
    private String firstPicture;

    public RecommendBlog() {
    }

    public RecommendBlog(Long id, String title, String firstPicture) {
        this.id = id;
        this.title = title;
        this.firstPicture = firstPicture;
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

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    @Override
    public String toString() {
        return "FirstPageBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                '}';
    }
}
