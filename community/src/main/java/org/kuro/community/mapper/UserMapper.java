package org.kuro.community.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.community.entity.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/28 12:28
 */
public interface UserMapper extends Mapper<User> {

    User findByUsername(@Param("username") String username);

    User findByEmail(@Param("email") String email);

}
