package com.jian.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jian.entity.Friend;
import com.jian.entity.Type;
import com.jian.service.FriendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @program: myblog
 * @description: 友链管理
 * @author: 520just
 * @create: 2021-08-27 09:56
 **/
@Controller
@RequestMapping("/admin")
public class FriendController {

    private final
    FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("/friends")
    public String getFriendLinks(@RequestParam(defaultValue = "1" , value = "pageNum") int pageNum, Model model){
        PageHelper.startPage(pageNum,10);
        List<Friend> allFriendLinks = friendService.getAllFriendLinks();
        PageInfo<Friend> pageInfo = new PageInfo<>(allFriendLinks);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/friendlinks";
    }

    //跳转到新增界面
    @GetMapping("/friends/input")
    public String inputFriendLink(Model model){
        model.addAttribute("friend",new Friend());
        return "admin/friendlinks-input";
    }

    //新增友链
    @PostMapping("/friends/save")
    public String saveFriendLink(Friend friend, RedirectAttributes attributes){
        Friend friend1 = friendService.getFriendLinkByUrl(friend.getUrl());
        if (friend1 != null) {
            attributes.addFlashAttribute("message","不能添加重复的友链");
            attributes.addFlashAttribute("friend",friend);
            return "redirect:/admin/friends/input";
        }
        int i = friendService.saveFriendLink(friend);
        if (i == 0) {
            attributes.addFlashAttribute("message","新增失败");
        } else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/friends";
    }

    //跳转到修改界面
    @GetMapping("/friends/{id}/edit")
    public String editFriendLink(@PathVariable int id,Model model){
        model.addAttribute("friend",friendService.getFriendLinkById(id));
        return "admin/friendlinks-input";
    }

    //保存修改
    @PostMapping("/friends/{id}/update")
    public String updateFriendLink(Friend friend, RedirectAttributes attributes){
        Friend friend1 = friendService.getFriendLinkByUrl(friend.getUrl());
        if (friend1 != null && friend1.getId() != friend.getId()) {
            attributes.addFlashAttribute("message","不能添加重复的友链");
            attributes.addFlashAttribute("friend",friend);
            return "admin/friendlinks-input";
        }
        int i = friendService.updateFriendLink(friend);
        if (i == 0) {
            attributes.addFlashAttribute("message","新增失败");
        } else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/friends";
    }

    @GetMapping("/friends/{id}/del")
    public String delFriendsLink(@PathVariable int id, RedirectAttributes attributes){
        int i = friendService.delType(id);
        if (i == 0) {
            attributes.addFlashAttribute("message","删除失败");
        } else {
            attributes.addFlashAttribute("message","删除成功");
        }
        return "redirect:/admin/friends";
    }

}
