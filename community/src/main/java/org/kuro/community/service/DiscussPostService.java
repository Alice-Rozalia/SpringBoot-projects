package org.kuro.community.service;

import org.kuro.community.entity.DiscussPost;

import java.util.List;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/28 16:51
 */
public interface DiscussPostService {

    /**
     * 查询帖子列表
     * @param userId
     * @param offset
     * @param limit
     * @return
     */
    List<DiscussPost> findDiscussPosts(Integer userId, Integer offset, Integer limit);

    /**
     * 帖子总数
     * @param userId
     * @return
     */
    Integer discussPostTotal(Integer userId);
}
