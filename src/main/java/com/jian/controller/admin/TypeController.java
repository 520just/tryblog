package com.jian.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jian.entity.Type;
import com.jian.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @program: myblog
 * @description: 分类管理
 * @author: 520just
 * @create: 2021-08-25 17:47
 **/
@Controller
@RequestMapping("/admin")
public class TypeController {

    final
    TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/types")
    public String getTypes(@RequestParam(defaultValue = "1" , value = "pageNum") int pageNum,Model model){
        PageHelper.startPage(pageNum,10);
        List<Type> types = typeService.getAllTypes();
        PageInfo<Type> pageInfo = new PageInfo<>(types);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/types";
    }

    //跳转到新增
    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    //新增分类
    @PostMapping("/types/save")
    public String saveType(Type type,RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            attributes.addFlashAttribute("message","不能添加重复的分类");
            return "redirect:/admin/types/input";
        }
        int i = typeService.saveType(type);
        if (i == 0) {
            attributes.addFlashAttribute("message","新增失败");
        } else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/types";
    }

    //跳转到修改
    @GetMapping("/types/{id}/edit")
    public String editType(@PathVariable Long id,Model model){
        Type type = typeService.getTypeById(id);
        model.addAttribute("type",type);
        return "admin/types-input";
    }

    //保存修改
    @PostMapping("/types/{id}/update")
    public String updateType(Type type,RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null && !type1.getId().equals(type.getId())) {
            attributes.addFlashAttribute("message","不能添加重复的分类");
            attributes.addFlashAttribute("type",type);
            return "admin/types-input";
        }
        int i = typeService.updateType(type);
        if (i == 0) {
            attributes.addFlashAttribute("message","修改失败");
        } else {
            attributes.addFlashAttribute("message","修改成功");
        }
        return "redirect:/admin/types";
    }

    //删除分类
    @GetMapping("/types/{id}/del")
    public String delType(@PathVariable Long id, RedirectAttributes attributes){
        typeService.delType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }

}
