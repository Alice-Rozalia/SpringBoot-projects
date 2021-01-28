package org.kuro.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/28 9:15
 */
@SpringBootApplication
@MapperScan("org.kuro.community.mapper")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
