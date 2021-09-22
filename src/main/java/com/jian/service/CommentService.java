package com.jian.service;

import com.jian.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getListCommentByBlogId(Long blogId);

    List<Comment> saveComment(Comment comment);

    void delComment(Long parentId,Long id);

    void delBlogCommentsByBlogId(Long blogId);

}
