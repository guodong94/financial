package com.cn.gd.seller.service;

import com.gd.api.ProductRpc;
import com.gd.api.domain.ProductRpcReq;
import com.gd.domain.entity.Product;
import com.gd.domain.enums.ProductStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/16 21:26
 * 产品服务类
 */
@Service
public class ProductRpcService {
    private static Logger logger = LoggerFactory.getLogger(ProductRpcService.class);

    @Autowired
    private ProductRpc productRpc;


    /**
     * 查询所有产品
     * @return
     */
    public List<Product> findAll(){
        ProductRpcReq req = new ProductRpcReq();
        List<String> status = new ArrayList<>();
        status.add(ProductStatus.IN_SELL.name());
        //Pageable pageable = new PageRequest(0,1000, Sort.Direction.DESC,"rewardRate");

        req.setStatus(status);

        logger.info("rpc查询全部产品：{}",req);
        List<Product> result = productRpc.query(req);
        logger.info("查询全部产品结果：{}",result);

        return result;
    }

    @PostConstruct
    public void testFindAll(){
        findAll();
    }
}
