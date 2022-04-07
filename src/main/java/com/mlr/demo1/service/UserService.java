package com.mlr.demo1.service;

import com.mlr.demo1.mapper.UserMapper;
import com.mlr.demo1.pojo.User;

import java.util.List;

/**
 * @author mlr
 * @version 1.0
 * @date 2022/3/31 18:30
 */

public interface UserService extends UserMapper {
    List<User> getUserList();

    User Login(User user);

}
