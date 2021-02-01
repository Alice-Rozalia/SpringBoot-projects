package org.kuro.community.service;

import org.kuro.community.entity.LoginTicket;
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

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Map<String, Object> login(String username, String password, Integer expiredSeconds);

    /**
     * 退出登录
     * @param ticket
     */
    void logout(String ticket);

    /**
     * 查询登录凭证
     * @param ticket
     * @return
     */
    LoginTicket findLoginTicket(String ticket);

    /**
     * 更新用户头像
     * @param user
     * @return
     */
    Integer updateHeader(User user);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User findUserByUsername(String username);
}
