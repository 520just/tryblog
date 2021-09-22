package com.jian.controller;

import com.jian.entity.Comment;
import com.jian.entity.User;
import com.jian.queryvo.DetailedBlog;
import com.jian.service.CommentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {

    private final
    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Value("${comment.avatar}")
    private String avatar;

    //查询评论列表
    @GetMapping("/comments/{id}")
    public String getComments(@PathVariable Long id, Model model){
        List<Comment> comments = commentService.getListCommentByBlogId(id);
        model.addAttribute("comments",comments);
        return "blog :: showComment";
    }

    //新增评论
    @PostMapping("/comments")
    public String saveComment(Comment comment, HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        if (user != null){
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        }else {
            comment.setAvatar(avatar);
        }
        List<Comment> comments = commentService.saveComment(comment);
        model.addAttribute("comments",comments);
        return "blog :: showComment";
    }

    //删除评论
    @GetMapping("/comments/del/{param1}/{param2}/{param3}")
    public String delComment(@PathVariable(value = "param1") Long blogId,@PathVariable(value = "param2") Long parentId ,
                             @PathVariable(value = "param3") Long id,Model model){
        commentService.delComment(parentId, id);
        return "redirect:/blog/"+blogId;
    }

}
