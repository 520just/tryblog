package com.jian.dao;

import com.jian.entity.Blog;
import com.jian.queryvo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogDao {

    List<SearchBlog> getAllBlog();

    List<SearchBlog> getBlogBySearch(String title,Long typeId);

    ShowBlog getShowBlogByBlogId(Long blogId);

    int saveBlog(Blog blog);

    int updateBlog(ShowBlog blog);

    int delBlogByBlogId(Long blogId);

    List<RecommendBlog> getAllRecommendBlog();

    List<FirstPageBlog> getFirstPageBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    List<FirstPageBlog> getBlogByTypeId(Long typeId);

    DetailedBlog getDetailedBlog(Long id);

    int updateViews(Long id);

    int updateCommentCount(Long id);

    Integer getBlogCount();

    Integer getBlogViewCount();

    Integer getCommentCount();

    Integer getMessageCount();

}
