package com.person.gen.common;

import lombok.Data;
import lombok.Getter;

/**
 * 响应结果枚举类
 *
 * @author xiaoming
 * @since 2020-04-13 20:34:54
 **/
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    PARAM_ERROR(400, "请求参数错误"),
    UNAUTHORIZED(401, "暂未登录或登录已过期"),
    FORBIDDEN(403, "没有相关权限"),
    NOT_FOUND(404, "没有找到请求资源");

    @Getter
    private int code;

    @Getter
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
