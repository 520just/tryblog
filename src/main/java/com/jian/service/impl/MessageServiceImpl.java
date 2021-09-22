package com.jian.service.impl;

import com.jian.dao.MessageDao;
import com.jian.entity.Message;
import com.jian.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final
    MessageDao messageDao;

    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    private List<Message> tempMessages = new ArrayList<>();

    @Override
    public List<Message> getMessages() {
        List<Message> messages = messageDao.getMessageByParentId(Long.parseLong("-1"));
        for (Message message : messages) {
            Long id = message.getId();
            String nickname = message.getNickname();
            getMessageByParentId(id,nickname);
            message.setReplayMessage(tempMessages);
            tempMessages = new ArrayList<>();
        }
        return messages;
    }

    //查询次层
    public void getMessageByParentId(Long parentId,String parentNickname) {
        List<Message> childMessages = messageDao.getMessageByParentId(parentId);
        if (childMessages.size() > 0) {
            for(Message message : childMessages) {
                Long id = message.getId();
                String nickname = message.getNickname();
                message.setParentId(parentId);
                message.setParentNickname(parentNickname);
                tempMessages.add(message);
                getMessageByParentId(id,nickname);
            }
        }
    }

    @Override
    public void saveMessage(Message message) {
        message.setCreateTime(new Date());
        messageDao.saveMessage(message);
    }

    @Override
    public void delMessageById(Long id,Long parentId) {
        messageDao.delMessageById(id);
        messageDao.updateMessageByParentId(id,parentId);
    }

}
