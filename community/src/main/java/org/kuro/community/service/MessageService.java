package org.kuro.community.service;

import org.kuro.community.entity.Message;

import java.util.List;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/31 22:08
 */
public interface MessageService {

    List<Message> findConversations(Integer userId, Integer offset, Integer limit);

    Integer findConversationCount(Integer userId);

    List<Message> findLetters(String conversationId, Integer offset, Integer limit);

    Integer findLetterCount(String conversationId);

    Integer findLetterUnreadCount(Integer userId, String conversationId);
}
