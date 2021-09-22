package com.jian.controller;

import com.jian.entity.Picture;
import com.jian.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @program: myblog
 * @description:
 * @author: 520just
 * @create: 2021-08-21 16:44
 **/
@Controller
public class PictureShowController {

    private final
    PictureService pictureService;

    public PictureShowController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/picture")
    public String getPictures(Model model){
        List<Picture> pictures = pictureService.getPictures();
        model.addAttribute("pictures",pictures);
        return "picture";
    }

}
