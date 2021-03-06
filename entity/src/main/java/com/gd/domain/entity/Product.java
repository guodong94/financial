package com.gd.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gd.domain.enums.ProductStatus;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
@Entity
public class Product {
    @Id
    private String id;//产品编号
    private String name;//产品名称
    /**
     * @see com.gd.domain.enums.ProductStatus
     */
    @ApiModelProperty(value = "状态",dataType = "com.gd.domain.enums.ProductStatus")
    private String status;//状态，AUDINTING：审核中，IN_SEll：销售中，LOCKED:暂停销售，FINISHED：已结束
    private BigDecimal thresholdAmount;//起投金额
    private BigDecimal stepAmount;//投资步长
    private Integer lockTerm;//锁定期
    private BigDecimal rewardRate;//收益率，因为要与金额相乘，所以类型使用BigDecimal
    private String memo;//备注
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;//更新时间
    private String createUser;//创建人
    private String updateUser;//更新者

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getThresholdAmount() {
        return thresholdAmount;
    }

    public void setThresholdAmount(BigDecimal thresholdAmount) {
        this.thresholdAmount = thresholdAmount;
    }

    public BigDecimal getStepAmount() {
        return stepAmount;
    }

    public void setStepAmount(BigDecimal stepAmount) {
        this.stepAmount = stepAmount;
    }

    public Integer getLockTerm() {
        return lockTerm;
    }

    public void setLockTerm(Integer lockTerm) {
        this.lockTerm = lockTerm;
    }

    public BigDecimal getRewardRate() {
        return rewardRate;
    }

    public void setRewardRate(BigDecimal rewardRate) {
        this.rewardRate = rewardRate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", thresholdAmount=" + thresholdAmount +
                ", stepAmount=" + stepAmount +
                ", lockTerm=" + lockTerm +
                ", rewardRate=" + rewardRate +
                ", memo='" + memo + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
