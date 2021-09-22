package com.jian.service.impl;

import com.jian.NotFoundException;
import com.jian.dao.BlogDao;
import com.jian.entity.Blog;
import com.jian.queryvo.*;
import com.jian.service.BlogService;
import com.jian.service.CommentService;
import com.jian.util.MarkdownUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    final
    BlogDao blogDao;

    final
    CommentService commentService;

    public BlogServiceImpl(BlogDao blogDao, CommentService commentService) {
        this.blogDao = blogDao;
        this.commentService = commentService;
    }

    @Override
    public List<SearchBlog> getAllBlog() {
        return blogDao.getAllBlog();
    }

    @Override
    public List<SearchBlog> getBlogBySearch(String title, Long typeId) {
        return blogDao.getBlogBySearch(title,typeId);
    }

    @Override
    public void delBlogByBlogId(Long blogId) {
        blogDao.delBlogByBlogId(blogId);
        commentService.delBlogCommentsByBlogId(blogId);
    }

    @Override
    public ShowBlog getShowBlogByBlogId(Long blogId) {
        return blogDao.getShowBlogByBlogId(blogId);
    }

    //新增博客
    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogDao.saveBlog(blog);
    }

    //编辑修改博客
    @Override
    public int updateBlog(ShowBlog blog) {
        blog.setUpdateTime(new Date());
        return blogDao.updateBlog(blog);
    }

    @Override
    public List<RecommendBlog> getAllRecommendBlog() {
        return blogDao.getAllRecommendBlog();
    }

    @Override
    public List<FirstPageBlog> getFirstPageBlog() {
        return blogDao.getFirstPageBlog();
    }

    @Override
    public List<FirstPageBlog> getSearchBlog(String query) {
        return blogDao.getSearchBlog(query);
    }

    @Override
    public List<FirstPageBlog> getBlogByTypeId(Long typeId) {
        return blogDao.getBlogByTypeId(typeId);
    }

    @Override
    public DetailedBlog getDetailedBlog(Long blogId) {
        DetailedBlog detailedBlog = blogDao.getDetailedBlog(blogId);
        if (detailedBlog == null){
            throw new NotFoundException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        //更新博客相关数据
        blogDao.updateViews(detailedBlog.getId());
        blogDao.updateCommentCount(detailedBlog.getId());
        return detailedBlog;
    }

    @Override
    public Integer getBlogCount() {
        return blogDao.getBlogCount();
    }

    @Override
    public Integer getBlogViewCount() {
        return blogDao.getBlogViewCount();
    }

    @Override
    public Integer getCommentCount() {
        return blogDao.getCommentCount();
    }

    @Override
    public Integer getMessageCount() {
        return blogDao.getMessageCount();
    }
}
