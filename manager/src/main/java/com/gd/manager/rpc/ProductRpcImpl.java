package com.gd.manager.rpc;

import com.gd.api.ProductRpc;
import com.gd.api.domain.ProductRpcReq;
import com.gd.domain.entity.Product;
import com.gd.manager.service.ProductService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/15 0:13
 * rpc服务实现类
 */
@AutoJsonRpcServiceImpl
@Service
public class ProductRpcImpl implements ProductRpc {
    private static Logger logger = LoggerFactory.getLogger(ProductRpcImpl.class);

    @Autowired
    private ProductService productService;

    @Override
    public List<Product> query(ProductRpcReq req) {
        logger.info("查询多个产品，请求{}",req);
        Pageable pageable = new PageRequest(0,1000,Sort.Direction.DESC,"rewardRate");
        Page<Product> query = productService.query(req.getIds(), req.getMinRewardRate(), req.getMaxRewardRate(), req.getStatus(), pageable);
        logger.info("查询多个产品，结果{}",query);
        return query.getContent();
    }

    @Override
    public Product findOne(String id) {
        logger.info("查询单个产品，请求：{}"+id);
        Product product = productService.findOne(id);
        logger.info("查询单个产品，结果：{}"+product);
        return product;
    }
}
