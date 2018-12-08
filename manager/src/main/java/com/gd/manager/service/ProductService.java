package com.gd.manager.service;

import com.gd.domain.entity.Product;
import com.gd.domain.enums.ProductStatus;
import com.gd.manager.error.ErrorEnum;
import com.gd.manager.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/7 22:49
 * 产品服务类
 */
@Service
public class ProductService {
    private static Logger LOG = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product){
        LOG.debug("创建产品--请求参数：{}"+product);
        //数据校验
        checkProduct(product);
        //设置默认值
        setDefault(product);

        Product result = productRepository.save(product);
        LOG.debug("返回值结果：{}"+result);
        return result;
    }

    /**
     * 根据产品编码查询单个产品
     * @param id
     * @return
     */
    public Product findOne(String id){
        Assert.notNull(id, ErrorEnum.ID_NOT_NYLL.getCode());
        LOG.debug("查询单个产品id={}",id);
        Product product = productRepository.findOne(id);
        LOG.debug("单个产品,结果={}",product);
        return product;
    }

    /**
     * 分页查询产品
     * @param idList
     * @param minRewardRate
     * @param maxRewardRate
     * @param statusList
     * @param pageable
     * @return
     */
    public Page<Product> query(List<String> idList, BigDecimal minRewardRate, BigDecimal maxRewardRate,
                               List<String> statusList, Pageable pageable){
        LOG.debug("查询产品参数：idList={}，minRewardRate={}，maxRewardRate={}，statusList={}，pageable={}",idList,minRewardRate,maxRewardRate,statusList,pageable);
        Specification<Product> specification = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Expression<String> idCol = root.get("idList");
                Expression<BigDecimal> rewardRateCol = root.get("rewardRate");
                Expression<BigDecimal> statusCol = root.get("status");
                //定义断言
                List<Predicate> predicates = new ArrayList<>();
                if (!CollectionUtils.isEmpty(idList)){
                    predicates.add(idCol.in(idList));
                }
                if (minRewardRate!=null && BigDecimal.ZERO.compareTo(minRewardRate)<0){
                    predicates.add(cb.ge(rewardRateCol,minRewardRate));
                }
                if (minRewardRate!=null && BigDecimal.ZERO.compareTo(minRewardRate)<0){
                    predicates.add(cb.le(rewardRateCol,maxRewardRate));
                }
                if (!CollectionUtils.isEmpty(statusList)){
                    predicates.add(statusCol.in(statusList));
                }
                query.where(predicates.toArray(new Predicate[0]));
                return null;
            }
        };
        Page<Product> productPage = productRepository.findAll(specification, pageable);
        LOG.debug("分页查询结果：",productPage);
        return productPage;
    }

    private void setDefault(Product product) {
        if (product.getCreateAt()==null){
            product.setCreateAt(new Date());
        }
        if (product.getUpdateAt()==null){
            product.setUpdateAt(new Date());
        }
        if (product.getLockTerm()==null){
            product.setLockTerm(0);
        }
        if (product.getStepAmount()==null){
            product.setStepAmount(BigDecimal.ZERO);
        }
        if (product.getStatus()==null){
            product.setStatus(ProductStatus.AUDITING.name());
        }
    }

    /**
     * 产品数据校验
     * 1.非空数据
     * 2.收益率要0-30以内
     * 3.投资步长需为整数
     * @param product
     */
    private void checkProduct(Product product) {
        Assert.notNull(product.getId(), ErrorEnum.ID_NOT_NYLL.getCode());
        //其他校验
        Assert.notNull(product.getName(),"产品名称不能为空");
        //Assert.notNull(product.getStatus(),"产品状态不能为空");

        //收益率要0-30以内
        Assert.isTrue(BigDecimal.ZERO.compareTo(product.getRewardRate())<0 && BigDecimal.valueOf(30).compareTo(product.getRewardRate()) >=0,"收益率范围错误（0-30）");
        Assert.isTrue(BigDecimal.valueOf(product.getStepAmount().longValue()).compareTo(product.getStepAmount())==0,"投资步长需为整数");


    }


}
