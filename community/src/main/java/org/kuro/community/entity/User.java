package org.kuro.community.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/28 12:24
 */
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                 // id
    private String username;            // 用户名
    private String password;            // 密码
    private String salt;                // 盐
    private String email;               // 邮箱
    private Integer type;               // 角色
    private Integer status;             // 状态
    private String activationCode;      // 激活码
    private String headerUrl;           // 头像
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;            // 创建时间
}
