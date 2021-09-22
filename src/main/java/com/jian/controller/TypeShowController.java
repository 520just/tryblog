package com.jian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jian.entity.Type;
import com.jian.queryvo.FirstPageBlog;
import com.jian.service.BlogService;
import com.jian.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TypeShowController {

    private final
    BlogService blogService;

    private final
    TypeService typeService;

    public TypeShowController(BlogService blogService, TypeService typeService) {
        this.blogService = blogService;
        this.typeService = typeService;
    }

    @GetMapping("/types")
    public String getTypeList(Model model){
        List<Type> types = typeService.getTypes();
        PageHelper.startPage(1,10);
        List<FirstPageBlog> blogs = blogService.getBlogByTypeId(types.get(0).getId());

        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("types",types);
        model.addAttribute("typeId",types.get(0).getId());
        model.addAttribute("pageInfo",pageInfo);
        return "types";
    }

    @GetMapping("/types/{typeId}/{pageNum}")
    public String getBlogs(@PathVariable(value = "typeId") Long typeId, @PathVariable(value = "pageNum") int pageNum, Model model){
        PageHelper.startPage(pageNum,10);
        List<FirstPageBlog> blogs = blogService.getBlogByTypeId(typeId);

        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("typeId",typeId);
        return "types :: showBlog";
    }

}
