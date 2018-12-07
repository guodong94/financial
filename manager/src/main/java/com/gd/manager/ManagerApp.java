package com.gd.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/7 22:13
 * 管理端启动类
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.gd.entity"})
public class ManagerApp {
    public static void main(String[] args){
        SpringApplication.run(ManagerApp.class);
    }
}
