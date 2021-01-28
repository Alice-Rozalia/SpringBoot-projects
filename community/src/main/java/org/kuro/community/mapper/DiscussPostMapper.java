package org.kuro.community.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.community.entity.DiscussPost;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/28 16:29
 */
public interface DiscussPostMapper extends Mapper<DiscussPost> {

    List<DiscussPost> findDiscussPosts(@Param("userId") Integer userId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    Integer discussPostTotal(@Param("userId") Integer userId);

}
