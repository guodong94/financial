package com.cn.gd.seller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/16 21:24
 * 销售端启动类
 */
@SpringBootApplication
public class SellerApp {
    public static void main(String[] args){
        SpringApplication.run(SellerApp.class);
    }
}
