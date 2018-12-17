package com.gd.api;

import com.gd.api.domain.ProductRpcReq;
import com.gd.domain.entity.Product;
import com.googlecode.jsonrpc4j.JsonRpcService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/10 23:56
 * 产品相关的Rpc服务
 */
@JsonRpcService("rpc/products")
@Component
public interface ProductRpc {
    /**
     * 查询多个产品
     * @param req
     * @return
     */
    List<Product> query(ProductRpcReq req);

    /**
     * 查询单个产品
     * @param id
     * @return
     */
    Product findOne(String id);

}
