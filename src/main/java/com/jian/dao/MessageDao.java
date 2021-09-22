package com.jian.dao;

import com.jian.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageDao {

    List<Message> getMessageByParentId(Long id);

    int saveMessage(Message message);

    int delMessageById(Long id);

    int updateMessageByParentId(Long id,Long parentId);

}
