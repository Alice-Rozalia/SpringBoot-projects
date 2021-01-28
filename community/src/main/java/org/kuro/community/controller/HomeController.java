package org.kuro.community.controller;

import org.kuro.community.entity.DiscussPost;
import org.kuro.community.entity.Page;
import org.kuro.community.entity.User;
import org.kuro.community.service.DiscussPostService;
import org.kuro.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/28 17:01
 */
@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getIndexPage(Model model, Page page) {
        // 方法调用栈，SpringMVC会自动实例化Model和Page，并将Page注入Model
        page.setRows(discussPostService.discussPostTotal(0));
        page.setPath("/");
        // 查询10条帖子
        List<DiscussPost> posts = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (posts != null) {
            // 遍历帖子集合，查找帖子作者
            for (DiscussPost post : posts) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }
}
