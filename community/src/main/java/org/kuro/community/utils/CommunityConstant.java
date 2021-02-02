package org.kuro.community.utils;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/29 14:53
 */
public interface CommunityConstant {

    // 激活成功
    Integer ACTIVE_SUCCESS = 0;

    // 重复激活
    Integer ACTIVE_REPEAT = 1;

    // 激活失败
    Integer ACTIVE_FAILURE = 2;

    // 默认状态的登录凭证的超时时间 (3小时)
    Integer DEFAULT_EXPIRED_SECONDS = 3600 * 3;

    // 记住状态的登录凭证的超时时间
    Integer REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 100;

    // 实体类型：帖子
    Integer ENTITY_TYPE_POST = 1;

    // 实体类型：评论
    Integer ENTITY_TYPE_COMMENT = 2;

    // 实体类型：用户
    Integer ENTITY_TYPE_USER = 3;
}
