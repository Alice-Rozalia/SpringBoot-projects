package org.kuro.community.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.kuro.community.entity.User;
import org.kuro.community.mapper.UserMapper;
import org.kuro.community.service.UserService;
import org.kuro.community.utils.CommunityConstant;
import org.kuro.community.utils.CommunityUtil;
import org.kuro.community.utils.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/28 16:57
 */
@Service
public class UserServiceImpl implements UserService, CommunityConstant {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${community.path.domain}")
    private String domain;

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */
    @Override
    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<>();

        // 对前端传递的用户对象进行校验
        if (user == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        if (StringUtils.isBlank(user.getUsername())) {
            map.put("usernameMsg", "账号不能为空！");
            return map;
        }
        if (StringUtils.isBlank(user.getPassword())) {
            map.put("passwordMsg", "密码不能为空！");
            return map;
        }
        if (StringUtils.isBlank(user.getEmail())) {
            map.put("emailMsg", "邮箱不能为空！");
            return map;
        }

        // 验证用户名是否已经被注册
        User byUsername = userMapper.findByUsername(user.getUsername());
        if (byUsername != null) {
            map.put("usernameMsg", "该账号已存在！");
            return map;
        }
        // 验证邮箱是否已经被注册
        User byEmail = userMapper.findByEmail(user.getEmail());
        if (byEmail != null) {
            map.put("emailMsg", "该邮箱已被注册！");
            return map;
        }

        user.setSalt(CommunityUtil.generateUUID().substring(0, 5));
        user.setPassword(CommunityUtil.md5(user.getPassword() + user.getSalt()));
        user.setType(0);
        user.setStatus(0);
        user.setActivationCode(CommunityUtil.generateUUID());
        user.setHeaderUrl(String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000)));
        user.setCreateTime(new Date());
        userMapper.insertSelective(user);

        // 发送激活邮件
        Context context = new Context();
        context.setVariable("email", user.getEmail());
        String url = domain + "/active/" + user.getId() + "/" + user.getActivationCode();
        context.setVariable("url", url);
        String content = templateEngine.process("/mail/activation", context);
        mailClient.sendMail(user.getEmail(), "激活账号", content);

        return map;
    }

    /**
     * 激活用户
     *
     * @param userId 用户id
     * @param code   激活码
     * @return
     */
    @Override
    public Integer active(Integer userId, String code) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user.getStatus() == 1) {
            return ACTIVE_REPEAT;
        } else if (user.getActivationCode().equals(code)) {
            user.setStatus(1);
            userMapper.updateByPrimaryKeySelective(user);
            return ACTIVE_SUCCESS;
        } else {
            return ACTIVE_FAILURE;
        }
    }

}
