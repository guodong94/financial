package com.gd.manager.error;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.smartcardio.ATR;
import java.util.List;
import java.util.Map;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/8 23:06
 * 自定义错误处理Controller
 */
public class MyErrorController extends BasicErrorController{


    public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorProperties, errorViewResolvers);
    }

    /**
     * {
     "timestamp": "2018-12-08 23:08:38",
     "status": 500,
     "error": "Internal Server Error",
     "exception": "java.lang.IllegalArgumentException",
     "message": "编号不可为空",
     "path": "/manager//product"
     }
     */
    @Override
    protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        Map<String, Object> attr = super.getErrorAttributes(request, includeStackTrace);
        attr.remove("error");
        String code = (String) attr.get("message");
        ErrorEnum errorEnum = ErrorEnum.getByCode(code);
        attr.put("code",errorEnum.getCode());
        attr.put("message",errorEnum.getMessage());
        attr.put("canRetry",errorEnum.isCanRetry());

        return attr;
    }
}
