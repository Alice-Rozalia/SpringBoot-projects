package org.kuro.community.service;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/2/1 23:05
 */
public interface LikeService {

    /**
     * 点赞
     * @param userId
     * @param entityType
     * @param entityId
     */
    void like(Integer userId, Integer entityType, Integer entityId, Integer entityUserId);

    /**
     * 查询某实体的点赞数量
     * @param entityType
     * @param entityId
     * @return
     */
    Long findEntityLikeCount(Integer entityType, Integer entityId);

    /**
     * 查询某人对实体的点赞状态
     * @param userId
     * @param entityType
     * @param entityId
     * @return
     */
    Integer findEntityLikeStatus(Integer userId, Integer entityType, Integer entityId);

    /**
     * 查询某个用户获得的赞
     * @param userId
     * @return
     */
    Integer findUserLikeCount(Integer userId);
}
