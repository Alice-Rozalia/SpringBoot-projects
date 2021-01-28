package org.kuro.community.service.impl;

import org.kuro.community.entity.DiscussPost;
import org.kuro.community.mapper.DiscussPostMapper;
import org.kuro.community.service.DiscussPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/28 16:51
 */
@Service
public class DiscussPostServiceImpl implements DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    /**
     * 查询帖子列表
     * @param userId
     * @param offset
     * @param limit
     * @return
     */
    @Override
    public List<DiscussPost> findDiscussPosts(Integer userId, Integer offset, Integer limit) {
        return discussPostMapper.findDiscussPosts(userId, offset, limit);
    }

    /**
     * 帖子总数
     * @param userId
     * @return
     */
    @Override
    public Integer discussPostTotal(Integer userId) {
        return discussPostMapper.discussPostTotal(userId);
    }
}
