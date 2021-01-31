package org.kuro.community.mapper;

import org.kuro.community.entity.Comment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/31 12:04
 */
public interface CommentMapper extends Mapper<Comment> {

    List<Comment> selectCommentsByEntity(Integer entityType, Integer entityId, Integer offset, Integer limit);

    Integer selectCountByEntity(Integer entityType, Integer entityId);
}
