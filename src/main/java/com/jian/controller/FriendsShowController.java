package com.jian.controller;

import com.jian.entity.Friend;
import com.jian.service.FriendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @program: myblog
 * @description:
 * @author: 520just
 * @create: 2021-08-21 11:25
 **/
@Controller
public class FriendsShowController {

    private final
    FriendService friendService;

    public FriendsShowController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("/friends")
    public String friends(Model model){
        List<Friend> friends = friendService.getFriends();
        model.addAttribute("friends",friends);
        return "friends";
    }

}
