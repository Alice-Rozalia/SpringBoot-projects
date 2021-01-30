package org.kuro.community.controller;

import org.kuro.community.entity.DiscussPost;
import org.kuro.community.entity.User;
import org.kuro.community.service.DiscussPostService;
import org.kuro.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/30 20:21
 */
@Controller
@RequestMapping("/discuss")
public class DiscussPostController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ResponseBody
    public String addDiscussPost(String title, String content) {
        DiscussPost post = new DiscussPost();
        post.setTitle(title);
        post.setContent(content);
        return discussPostService.addDiscussPost(post);
    }

    @GetMapping("/detail/{discussPostId}")
    public String getDiscussPost(@PathVariable("discussPostId") Integer discussPostId, Model model) {
        DiscussPost post = discussPostService.findDiscussPostById(discussPostId);
        model.addAttribute("post", post);
        User user = userService.findUserById(post.getUserId());
        model.addAttribute("user", user);

        return "/site/discuss-detail";
    }
}
