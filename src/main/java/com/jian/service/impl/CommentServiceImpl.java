package com.jian.service.impl;

import com.jian.dao.CommentDao;
import com.jian.entity.Comment;
import com.jian.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    final
    CommentDao commentDao;

    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    //存放迭代的子评论
    private List<Comment> tempComments = new ArrayList<>();

    //新增评论
    @Override
    public List<Comment> saveComment(Comment comment) {
        comment.setCreatTime(new Date());
        commentDao.saveComment(comment);
        return getListCommentByBlogId(comment.getBlogId());
    }

    //删除评论
    @Override
    public void delComment(Long parentId, Long id) {
        //删除并更新子评论
        commentDao.delComment(id);
        commentDao.updateComments(parentId,id);
    }

    //删除博客所有评论
    @Override
    public void delBlogCommentsByBlogId(Long blogId) {
        commentDao.delBlogCommentsByBlogId(blogId);
    }

    //查询所有
    @Override
    public List<Comment> getListCommentByBlogId(Long blogId) {
        List<Comment> comments = commentDao.getCommentByBlogId(blogId);
        for (Comment comment : comments) {
            String nickname = comment.getNickname();
            Long id = comment.getId();
            List<Comment> childComments = commentDao.getCommentByParentId(id);
            //查询子评论
            getChileCommentByParentId(id,childComments,nickname);
            comment.setReplyComments(tempComments);
            tempComments = new ArrayList<>();
        }
        return comments;
    }

    //查询次层
    public void getChileCommentByParentId(Long parentId,List<Comment> parentComments,String parentNickname) {
        if (parentComments.size() > 0) {
            for (Comment comment : parentComments) {
                comment.setParentCommentId(parentId);
                comment.setParentNickname(parentNickname);
                tempComments.add(comment);
                Long id = comment.getId();
                List<Comment> childComments = commentDao.getCommentByParentId(id);
                String nickname = comment.getNickname();
                getChileCommentByParentId(id,childComments,nickname);
            }
        }
    }
}
