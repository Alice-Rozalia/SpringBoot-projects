package org.kuro.community.service;

import org.kuro.community.entity.Comment;

import java.util.List;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/31 12:48
 */
public interface CommentService {

    /**
     * 根据实体类类型查询评论
     * @param entityType
     * @param entityId
     * @param offset
     * @param limit
     * @return
     */
    List<Comment> findCommentsByEntity(Integer entityType, Integer entityId, Integer offset, Integer limit);

    /**
     * 根据实体类类型查询评论总数
     * @param entityType
     * @param entityId
     * @return
     */
    Integer findCountByEntity(Integer entityType, Integer entityId);
}
