package com.gd.manager;

import com.gd.swagger.EnableMySwagger;
import com.gd.swagger.SwaggerConfigration;
import io.swagger.models.Swagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/7 22:13
 * 管理端启动类
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.gd.domain"})
//@Import(SwaggerConfigration.class)
@EnableMySwagger
//@EnableSwagger2
public class ManagerApp {
    public static void main(String[] args){
        SpringApplication.run(ManagerApp.class);
    }
}
