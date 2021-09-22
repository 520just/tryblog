package com.jian.service;

import com.jian.entity.Message;

import java.util.List;

public interface MessageService {

    List<Message> getMessages();

    void saveMessage(Message message);

    void delMessageById(Long id,Long parentId);

}
