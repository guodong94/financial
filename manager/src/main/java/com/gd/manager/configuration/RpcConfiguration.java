package com.gd.manager.configuration;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/15 0:26
 * rpc相关配置
 */
@Configuration
public class RpcConfiguration {

    @Bean
    public AutoJsonRpcServiceImplExporter recServiceImplExproter(){
        return new AutoJsonRpcServiceImplExporter();
    }
}
