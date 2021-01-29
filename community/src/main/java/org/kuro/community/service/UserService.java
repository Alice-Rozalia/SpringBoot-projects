package org.kuro.community.service;

import org.kuro.community.entity.User;

import java.util.Map;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/28 16:56
 */
public interface UserService {

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * 注册
     * @param user
     * @return
     */
    Map<String, Object> register(User user);

    /**
     * 激活用户
     * @param userId    用户id
     * @param code      激活码
     * @return
     */
    Integer active(Integer userId, String code);
}
