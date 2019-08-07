package com.xw.service;

import com.xw.bean.User;
import com.xw.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }
}
