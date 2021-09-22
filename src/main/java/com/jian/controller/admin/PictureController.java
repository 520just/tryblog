package com.jian.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jian.entity.Picture;
import com.jian.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @program: myblog
 * @description: 图片管理
 * @author: 520just
 * @create: 2021-08-28 09:09
 **/
@Controller
@RequestMapping("/admin")
public class PictureController {

    final
    PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/pictures")
    public String getPictures(@RequestParam(defaultValue = "1" , value = "pageNum") int pageNum, Model model) {
        PageHelper.startPage(pageNum,10);
        List<Picture> pictures = pictureService.getPictures();
        PageInfo<Picture> pageInfo = new PageInfo<>(pictures);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/pictures";
    }

    @GetMapping("/pictures/input")
    public String inputPicture(Model model) {
        model.addAttribute("picture",new Picture());
        return "admin/pictures-input";
    }

    @PostMapping("/pictures/save")
    public String savePicture(Picture picture,RedirectAttributes attributes){
        int i = pictureService.savePicture(picture);
        if (i == 0) {
            attributes.addFlashAttribute("message","新增失败");
        } else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/pictures";
    }

    @GetMapping("/pictures/{id}/edit")
    public String editPicture(@PathVariable Long id,Model model) {
        Picture picture = pictureService.getPictureById(id);
        model.addAttribute("picture",picture);
        return "admin/pictures-input";
    }

    @PostMapping("/pictures/{id}/update")
    public String updatePicture(Picture picture,RedirectAttributes attributes){
        int i = pictureService.updatePicture(picture);
        if (i == 0) {
            attributes.addFlashAttribute("message","修改失败");
        } else {
            attributes.addFlashAttribute("message","修改成功");
        }
        return "redirect:/admin/pictures";
    }

    @GetMapping("/pictures/{id}/del")
    public String delPicture(@PathVariable Long id, RedirectAttributes attributes) {
        pictureService.delPictureById(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/pictures";
    }

}
