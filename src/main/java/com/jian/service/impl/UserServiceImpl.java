package com.jian.service.impl;

import com.jian.dao.UserDao;
import com.jian.entity.User;
import com.jian.service.UserService;
import com.jian.util.MD5Utils;
import org.springframework.stereotype.Service;

/**
 * @program: myblog
 * @description: 用户相关控制
 * @author: 520just
 * @create: 2021-08-23 10:06
 **/
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.checkUser(username);
        if (MD5Utils.code(password).equals(user.getPassword())){
            return user;
        }
        System.out.println(MD5Utils.code(password));
        return null;
    }
}
