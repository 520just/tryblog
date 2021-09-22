package com.jian;

import com.jian.entity.Comment;
import com.jian.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyblogApplicationTests {

    @Autowired
    CommentService commentService;

    @Test
    void contextLoads() {
        List<Comment> listCommentByBlogId = commentService.getListCommentByBlogId(1L);
        System.out.println("ss");
    }

}
