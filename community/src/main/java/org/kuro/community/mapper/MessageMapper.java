package org.kuro.community.mapper;

import org.kuro.community.entity.Message;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/31 20:37
 */
public interface MessageMapper extends Mapper<Message> {

    // 查询当前用户的会话列表，针对每个会话只返回一条最新的私信
    List<Message> selectConversations(Integer userId, Integer offset, Integer limit);

    // 查询当前用户的会话数量
    Integer selectConversationCount(Integer userId);

    // 查询某个会话包含的私信列表
    List<Message> selectLetters(String conversationId, Integer offset, Integer limit);

    // 查询某个会话所包含的私信数量
    Integer selectLetterCount(String conversationId);

    // 查询未读私信的数量
    Integer selectLetterUnreadCount(Integer userId, String conversationId);
}
