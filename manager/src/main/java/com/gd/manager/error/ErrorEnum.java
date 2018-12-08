package com.gd.manager.error;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/8 23:29
 * 错误种类
 */
public enum ErrorEnum {
    ID_NOT_NYLL("F001", "编号不能为空", false),
    UNKNOWN("F999", "未知异常", true);
    //...
    ;
    private String code;
    private String message;
    private boolean canRetry;//是否可重试

    ErrorEnum(String code, String message, boolean canRetry) {
        this.code = code;
        this.message = message;
        this.canRetry = canRetry;
    }

    /**
     * 通过code获取异常种类
     *
     * @param code
     * @return
     */
    public static ErrorEnum getByCode(String code) {
        for (ErrorEnum errorEnum : ErrorEnum.values()) {
            if (code.equals(errorEnum.code)) {
                return errorEnum;
            }
        }
        return UNKNOWN;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isCanRetry() {
        return canRetry;
    }
}

