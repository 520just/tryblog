package com.jian.service;

import com.jian.entity.Blog;
import com.jian.queryvo.*;

import java.util.List;

public interface BlogService {

    List<SearchBlog> getAllBlog();

    List<SearchBlog> getBlogBySearch(String title,Long typeId);

    void delBlogByBlogId(Long blogId);

    ShowBlog getShowBlogByBlogId(Long blogId);

    int saveBlog(Blog blog);

    int updateBlog(ShowBlog blog);

    List<RecommendBlog> getAllRecommendBlog();

    List<FirstPageBlog> getFirstPageBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    List<FirstPageBlog> getBlogByTypeId(Long typeId);

    DetailedBlog getDetailedBlog(Long blogId);

    Integer getBlogCount();

    Integer getBlogViewCount();

    Integer getCommentCount();

    Integer getMessageCount();

}
