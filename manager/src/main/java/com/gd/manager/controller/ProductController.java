package com.gd.manager.controller;

import com.gd.entity.Product;
import com.gd.manager.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/7 23:48
 */
@RestController
public class ProductController {
    private static Logger LOG = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;

    @PatchMapping(value = "/addProduct")
    public Product addProduct(@RequestBody Product product){
        LOG.info("创建产品--请求参数：{}"+product);
        Product result = productService.addProduct(product);
        LOG.info("返回值结果：{}"+result);
        return result;
    }
    @GetMapping(value = "/Product/{id}")
    public Product findOne(@PathVariable String id){
        LOG.info("产品编码，id={}",id);
        Product product = productService.findOne(id);
        LOG.info("单个产品结果={}",product);
        return product;
    }
    @GetMapping(value = "")
    public Page<Product> query(String ids, BigDecimal minRewardRate, BigDecimal maxRewardRate,
                               String status,@RequestParam(defaultValue = "0") int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        LOG.info("查询产品参数：ids={}，minRewardRate={}，maxRewardRate={}，statusList={}，pageNum={},pageSize={}",ids,minRewardRate,maxRewardRate,status,pageNum,pageSize);
        List<String> idsList=null,statusList=null;
        if (!StringUtils.isEmpty(ids)){
            idsList= Arrays.asList(ids.split(","));
        }
        if (!StringUtils.isEmpty(status)){
            statusList= Arrays.asList(status.split(","));
        }
        Pageable pageable = new PageRequest(pageNum,pageSize);

        Page<Product> products = productService.query(idsList, minRewardRate, maxRewardRate, statusList, pageable);
        LOG.info("分页查询结果：",products);
        return products;
    }
}

