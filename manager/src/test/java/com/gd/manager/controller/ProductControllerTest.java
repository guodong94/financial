package com.gd.manager.controller;

import com.gd.domain.entity.Product;
import com.gd.domain.enums.ProductStatus;
import com.gd.util.RestUtil;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/9 12:18
 * 产品测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductControllerTest {

    private static RestTemplate restTemplate = new RestTemplate();

    @Value("http://localhost:${local.server.port}/manager")
    private String baseUrl;

    private static List<Product> productList = new ArrayList<>();
    private static List<Product> errorProduct = new ArrayList<>();

    @BeforeClass
    public static void init() {

        Product p1 = new Product();
        p1.setId("00" + 1);
        p1.setName("产品" + 1);
        p1.setStepAmount(BigDecimal.valueOf(1));
        p1.setRewardRate(BigDecimal.valueOf(1));
        p1.setThresholdAmount(BigDecimal.valueOf(1));
        p1.setStatus(ProductStatus.AUDITING.name());

        Product p2 = new Product();
        p2.setId(null);
        p2.setName("产品" + 2);
        p2.setStepAmount(BigDecimal.valueOf(1));
        p2.setRewardRate(BigDecimal.valueOf(1));
        p2.setThresholdAmount(BigDecimal.valueOf(1));
        p2.setStatus(ProductStatus.AUDITING.name());
        productList.add(p1);
        errorProduct.add(p2);

        ResponseErrorHandler errorHandler = new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        };
        restTemplate.setErrorHandler(errorHandler);

    }

    @Test
    public void create() {
        productList.forEach(product -> {
            Product result = RestUtil.postJSON(restTemplate, baseUrl + "/product", product, Product.class);
            Assert.notNull(result.getCreateAt(), "插入失败");
        });
    }

    @Test
    public void createException(){
        errorProduct.forEach(product -> {
            Map<String,String> result = RestUtil.postJSON(restTemplate,baseUrl+"/product",product, HashMap.class);
            Assert.isTrue(result.get("message").equals("编号不能为空"),"测试成功");
        });
    }

    @Test
    public void findOne(){
        productList.forEach(product -> {
            Product result = restTemplate.getForObject(baseUrl + "/product/" + product.getId(), Product.class);
            Assert.notNull(product!=null,"查询成功");
        });

        errorProduct.forEach(product -> {
            Product rsult = restTemplate.getForObject(baseUrl + "/product/" + product.getId(), Product.class);
            Assert.isNull(rsult,"查询失败");

        });
    }
}

