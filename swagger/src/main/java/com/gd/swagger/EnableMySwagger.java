package com.gd.swagger;

import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/9 23:47
 * 文档自动生成功能
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Documented
@Import(SwaggerConfigration.class)
public @interface EnableMySwagger {
}
