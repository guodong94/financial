package com.gd.api.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Dictionary;
import java.util.List;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/15 0:00
 * 产品相关rpc参数
 */

public class ProductRpcReq {

    private List<String> ids;
    private BigDecimal minRewardRate;
    private BigDecimal maxRewardRate;
    private List<String> status;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public BigDecimal getMinRewardRate() {
        return minRewardRate;
    }

    public void setMinRewardRate(BigDecimal minRewardRate) {
        this.minRewardRate = minRewardRate;
    }

    public BigDecimal getMaxRewardRate() {
        return maxRewardRate;
    }

    public void setMaxRewardRate(BigDecimal maxRewardRate) {
        this.maxRewardRate = maxRewardRate;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
