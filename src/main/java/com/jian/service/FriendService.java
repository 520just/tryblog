package com.jian.service;

import com.jian.entity.Friend;

import java.util.List;

public interface FriendService {

    List<Friend> getFriends();

    List<Friend> getAllFriendLinks();

    Friend getFriendLinkById(int id);

    Friend getFriendLinkByUrl(String url);

    int saveFriendLink(Friend friend);

    int updateFriendLink(Friend friend);

    int delType(int id);

}
