package org.kuro.community.service;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/2/2 12:22
 */
public interface FollowService {

    void follow(Integer userId, Integer entityType, Integer entityId);

    void unFollow(int userId, int entityType, int entityId);
}
