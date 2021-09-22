package com.jian.dao;

import com.jian.entity.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FriendDao {

    List<Friend> getFriends();

    List<Friend> getAllFriendLinks();

    Friend getFriendLinkById(int id);

    Friend getFriendLinkByUrl(String url);

    int saveFriendLink(Friend friend);

    int updateFriendLink(Friend friend);

    int delFriendLink(int id);

}
