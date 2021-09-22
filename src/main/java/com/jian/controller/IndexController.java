package com.jian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jian.entity.Comment;
import com.jian.queryvo.DetailedBlog;
import com.jian.queryvo.FirstPageBlog;
import com.jian.queryvo.RecommendBlog;
import com.jian.service.BlogService;
import com.jian.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    //通过构造器注入解决Field injection is not recommended
    private final
    BlogService blogService;

    private final
    CommentService commentService;

    public IndexController(BlogService blogService, CommentService commentService) {
        this.blogService = blogService;
        this.commentService = commentService;
    }

    //分页查询博客列表
    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1" , value = "currentPage") int pageNum){//RedirectAttributes attributes
        PageHelper.startPage(pageNum,10);
        List<FirstPageBlog> firstPageBlog = blogService.getFirstPageBlog();
        List<RecommendBlog> allRecommendBlog = blogService.getAllRecommendBlog();

        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(firstPageBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("recommendBlogs",allRecommendBlog);
        return "index";
    }

    //搜索
    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam(defaultValue = "1" , value = "currentPage") int pageNum, @RequestParam String query){
        PageHelper.startPage(pageNum,1000);
        List<FirstPageBlog> searchBlog = blogService.getSearchBlog(query);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("query",query);
        return "search";
    }

    //查看博客详情页面
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model){
        DetailedBlog blog = blogService.getDetailedBlog(id);
        List<Comment> comments = commentService.getListCommentByBlogId(id);
        model.addAttribute("blog",blog);
        model.addAttribute("comments",comments);
        return "blog";
    }

    //网站信息
    @GetMapping("/footer/blogmessage")
    public String blogMessage(Model model){
        model.addAttribute("blogCount",blogService.getBlogCount());
        model.addAttribute("viewCount",blogService.getBlogViewCount());
        model.addAttribute("commentCount",blogService.getCommentCount());
        model.addAttribute("messageCount",blogService.getMessageCount());
        return "index :: blogMessage";
    }


}
