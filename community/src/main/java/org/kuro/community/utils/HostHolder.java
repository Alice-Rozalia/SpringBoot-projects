package org.kuro.community.utils;

import org.kuro.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/30 10:51
 *
 * 持有用户的信息，用于代替session对象
 */
@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }
}
