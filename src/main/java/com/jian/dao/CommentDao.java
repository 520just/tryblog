package com.jian.dao;

import com.jian.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentDao {

    //查询顶层评论
    List<Comment> getCommentByBlogId(Long id);

    //查询次层评论
    List<Comment> getCommentByParentId(Long id);

    //新增评论
    int saveComment(Comment comment);

    //删除评论
    int delComment(Long id);

    //修改父节点问题
    int updateComments(Long parentId,Long id);

    //删除一个博客的所有评论
    int delBlogCommentsByBlogId(Long blogId);

}
