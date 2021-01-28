package org.kuro.community.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/28 16:23
 */
@Data
public class DiscussPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                 // id
    private Integer userId;             // 用户id
    private String title;               // 标题
    private String content;             // 内容
    private Integer type;               // 0-普通; 1-置顶;
    private Integer status;             // 0-正常; 1-精华; 2-拉黑;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;            // 创建时间
    private Integer commentCount;       // 评论数量
    private Double score;               // 分数（热度排序）

}
