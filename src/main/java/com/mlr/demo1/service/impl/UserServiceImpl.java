package com.mlr.demo1.service.impl;

import com.mlr.demo1.mapper.UserMapper;
import com.mlr.demo1.pojo.User;
import com.mlr.demo1.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mlr
 * @version 1.0
 * @date 2022/3/31 18:30
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public User Login(User user) {
        User login= userMapper.Login(user);
        return login;
    }


}
