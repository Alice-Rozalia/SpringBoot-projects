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

    /**
     * 发布帖子
     * @param discussPost
     * @return
     */
    String addDiscussPost(DiscussPost discussPost);

    /**
     * 根据id查询帖子
     * @param id
     * @return
     */
    DiscussPost findDiscussPostById(Integer id);

    /**
     * 更新评论数量
     * @param discussPost
     * @return
     */
    Integer updateCommentCount(DiscussPost discussPost);
}
