package com.gd.domain.enums;

/**
 * 订单状态
 */
public enum OrderStatue {
    INIT("初始化"),
    PROCESS("处理中"),
    SUCCESS("成功"),
    FAIL("失败");

    private String desc;

    OrderStatue(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
