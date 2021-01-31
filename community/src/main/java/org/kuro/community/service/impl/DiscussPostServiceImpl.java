package org.kuro.community.service.impl;

import org.kuro.community.entity.DiscussPost;
import org.kuro.community.entity.User;
import org.kuro.community.mapper.DiscussPostMapper;
import org.kuro.community.service.DiscussPostService;
import org.kuro.community.utils.CommunityUtil;
import org.kuro.community.utils.HostHolder;
import org.kuro.community.utils.SensitiveFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/28 16:51
 */
@Service
public class DiscussPostServiceImpl implements DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Autowired
    private HostHolder hostHolder;

    /**
     * 查询帖子列表
     *
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
     *
     * @param userId
     * @return
     */
    @Override
    public Integer discussPostTotal(Integer userId) {
        return discussPostMapper.discussPostTotal(userId);
    }

    /**
     * 发布帖子
     *
     * @param discussPost
     * @return
     */
    @Override
    public String addDiscussPost(DiscussPost discussPost) {
        if (discussPost == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        User user = hostHolder.getUser();
        if (user == null) {
            return CommunityUtil.getJSONString(403, "您还没有登录！");
        }
        discussPost.setUserId(user.getId());
        // 转义HTML标记
        discussPost.setTitle(HtmlUtils.htmlEscape(discussPost.getTitle()));
        discussPost.setContent(HtmlUtils.htmlEscape(discussPost.getContent()));
        // 过滤敏感词
        discussPost.setTitle(sensitiveFilter.filter(discussPost.getTitle()));
        discussPost.setContent(sensitiveFilter.filter(discussPost.getContent()));

        discussPost.setCreateTime(new Date());
        discussPost.setCommentCount(0);
        discussPost.setStatus(0);
        discussPost.setType(0);

        discussPostMapper.insertSelective(discussPost);
        return CommunityUtil.getJSONString(0, "发布成功！");
    }

    /**
     * 根据id查询帖子
     *
     * @param id
     * @return
     */
    @Override
    public DiscussPost findDiscussPostById(Integer id) {
        return discussPostMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新评论数量
     *
     * @param discussPost
     * @return
     */
    @Override
    public Integer updateCommentCount(DiscussPost discussPost) {
        return discussPostMapper.updateByPrimaryKeySelective(discussPost);
    }
}
