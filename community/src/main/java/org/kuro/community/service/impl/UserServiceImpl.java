package org.kuro.community.service.impl;

import org.kuro.community.entity.User;
import org.kuro.community.mapper.UserMapper;
import org.kuro.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/28 16:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */
    @Override
    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
