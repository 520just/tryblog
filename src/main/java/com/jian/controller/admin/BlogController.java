package com.jian.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jian.entity.Blog;
import com.jian.entity.Type;
import com.jian.entity.User;
import com.jian.queryvo.SearchBlog;
import com.jian.queryvo.ShowBlog;
import com.jian.service.BlogService;
import com.jian.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: myblog
 * @description: 文章管理
 * @author: 520just
 * @create: 2021-08-24 09:42
 **/
@Controller
@RequestMapping("/admin")
public class BlogController {

    private final TypeService typeService;

    private final BlogService blogService;

    public BlogController(TypeService typeService, BlogService blogService) {
        this.typeService = typeService;
        this.blogService = blogService;
    }

    //跳转到管理页面
    @GetMapping("/blogs")
    public String getBlogs(@RequestParam(defaultValue = "1" , value = "pageNum") int pageNum, Model model){
        List<Type> types = typeService.getAllTypes();
        PageHelper.startPage(pageNum,10);
        List<SearchBlog> allBlog = blogService.getAllBlog();
        PageInfo<SearchBlog> pageInfo = new PageInfo<>(allBlog);
        model.addAttribute("types",types);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs";
    }

    //跳转到博客新增界面
    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("types",typeService.getAllTypes());
        return "admin/blogs-input";
    }

    //新增博客
    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){
        User user = (User) session.getAttribute("user");
        blog.setUserId(user.getId());
        int i = blogService.saveBlog(blog);
        if (i == 0){
            attributes.addFlashAttribute("message","新增失败");
        } else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/blogs";
    }

    //跳转到文章编辑
    @GetMapping("/blogs/{blogId}/input")
    public String editInput(@PathVariable Long blogId,Model model){
        ShowBlog blog = blogService.getShowBlogByBlogId(blogId);
        List<Type> types = typeService.getAllTypes();
        model.addAttribute("blog",blog);
        model.addAttribute("types",types);
        return "admin/blogs-input";
    }

    //编辑修改文章
    @PostMapping("/blogs/{id}")
    public String editPost(ShowBlog blog, RedirectAttributes attributes){
        int i = blogService.updateBlog(blog);
        if (i == 0) {
            attributes.addFlashAttribute("message","修改失败");
        } else {
            attributes.addFlashAttribute("message","修改成功");
        }
        return "redirect:/admin/blogs";
    }

    //删除文章
    @GetMapping("/blogs/{blogId}/del")
    public String delBlog(@PathVariable Long blogId, RedirectAttributes attributes){
        blogService.delBlogByBlogId(blogId);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String search(@RequestParam(defaultValue = "1" , value = "pageNum") int pageNum,Blog blog,Model model){
        PageHelper.startPage(pageNum,10);
        List<SearchBlog> blogs = blogService.getBlogBySearch(blog.getTitle(), blog.getTypeId());
        PageInfo<SearchBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs :: blogList";
    }

}
