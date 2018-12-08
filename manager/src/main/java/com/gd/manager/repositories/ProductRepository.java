package com.gd.manager.repositories;

import com.gd.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/7 22:39
 * 产品管理
 */
public interface ProductRepository extends JpaRepository<Product,String>,JpaSpecificationExecutor<Product>{
}
