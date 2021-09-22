package com.jian.service.impl;

import com.jian.dao.FriendDao;
import com.jian.entity.Friend;
import com.jian.service.FriendService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: myblog
 * @description:
 * @author: 520just
 * @create: 2021-08-21 11:29
 **/
@Service
public class FriendsServiceImpl implements FriendService {

    final
    FriendDao friendDao;

    public FriendsServiceImpl(FriendDao friendDao) {
        this.friendDao = friendDao;
    }

    @Override
    public List<Friend> getFriends() {
        return friendDao.getFriends();
    }

    @Override
    public List<Friend> getAllFriendLinks() {
        return friendDao.getAllFriendLinks();
    }

    @Override
    public Friend getFriendLinkById(int id) {
        return friendDao.getFriendLinkById(id);
    }

    @Override
    public Friend getFriendLinkByUrl(String url) {
        return friendDao.getFriendLinkByUrl(url);
    }

    @Override
    public int saveFriendLink(Friend friend) {
        friend.setCreateTime(new Date());
        return friendDao.saveFriendLink(friend);
    }

    @Override
    public int updateFriendLink(Friend friend) {
        friend.setCreateTime(new Date());
        return friendDao.updateFriendLink(friend);
    }

    @Override
    public int delType(int id) {
        return friendDao.delFriendLink(id);
    }

}
