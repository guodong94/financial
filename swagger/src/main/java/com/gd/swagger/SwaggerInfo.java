package com.gd.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/9 23:28
 * Swagger 配置信息
 */
@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerInfo {
    private String groupName = "controller";

    private String basePackage;

    private String antPath;

    private String title = "HTTP API";

    private String description = "Swagger 自动生成接口文档";

    private String license = "Apache License Version 2.0";

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getAntPath() {
        return antPath;
    }

    public void setAntPath(String antPath) {
        this.antPath = antPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
