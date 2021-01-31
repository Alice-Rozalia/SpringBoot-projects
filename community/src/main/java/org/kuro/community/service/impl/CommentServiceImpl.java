package org.kuro.community.service.impl;

import org.kuro.community.entity.Comment;
import org.kuro.community.mapper.CommentMapper;
import org.kuro.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/31 12:49
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 根据实体类类型查询评论
     *
     * @param entityType
     * @param entityId
     * @param offset
     * @param limit
     * @return
     */
    @Override
    public List<Comment> findCommentsByEntity(Integer entityType, Integer entityId, Integer offset, Integer limit) {
        return commentMapper.selectCommentsByEntity(entityType, entityId, offset, limit);
    }

    /**
     * 根据实体类类型查询评论总数
     *
     * @param entityType
     * @param entityId
     * @return
     */
    @Override
    public Integer findCountByEntity(Integer entityType, Integer entityId) {
        return commentMapper.selectCountByEntity(entityType, entityId);
    }

}
