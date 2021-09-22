package com.jian.controller;

import com.jian.entity.Message;
import com.jian.entity.User;
import com.jian.service.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MessageController {

    private final
    MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/message")
    public String getMessages(Model model){
        List<Message> messages = messageService.getMessages();
        model.addAttribute("messages",messages);
        return "message";
    }

    @GetMapping("/message/del/{id}/{parentId}")
    public String delMessageById(@PathVariable(value = "id") Long id,@PathVariable(value = "parentId") Long parentId){
        messageService.delMessageById(id,parentId);
        return "redirect:/message";
    }

    @PostMapping("/message")
    public String saveMessage(Message message, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if (user != null) {
            message.setAvatar(user.getAvatar());
            message.setAdminMessage(true);
        }else {
            message.setAvatar(avatar);
        }
        messageService.saveMessage(message);
        model.addAttribute("messages",messageService.getMessages());
        return "message :: showMessage";
    }

}
