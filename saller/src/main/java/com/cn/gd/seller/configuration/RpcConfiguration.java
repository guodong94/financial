package com.cn.gd.seller.configuration;

import com.gd.api.ProductRpc;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcClientProxyCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/16 21:30
 * rpc相关配置
 */
@Configuration
@ComponentScan(basePackageClasses = {ProductRpc.class})
public class RpcConfiguration {
    public static Logger logger = LoggerFactory.getLogger(RpcConfiguration.class);

    @Bean
    public AutoJsonRpcClientProxyCreator rpcClientProxyCreator(@Value("${rpc.manager.url}") String url){
        AutoJsonRpcClientProxyCreator creator = new AutoJsonRpcClientProxyCreator();
        try {
            creator.setBaseUrl(new URL(url));
        } catch (MalformedURLException e) {
            logger.error("创建服务地址错误：",e);
        }
        creator.setScanPackage(ProductRpc.class.getPackage().getName());

        return creator;

    }
}
