package org.kuro.community.service;

import org.kuro.community.entity.User;

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

}
