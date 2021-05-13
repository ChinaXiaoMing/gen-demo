package com.person.gen.common;

import lombok.Getter;

/**
 * 响应结果枚举类
 *
 * @author xiaoming
 * @since 2020-04-13 20:34:54
 **/
public enum ResultCode {
	/**
	 * 返回结果 200：操作成功，500：操作失败，400：请求参数错误，401：登录过期，403：无权限，404：找不到请求资源
	 */
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    PARAM_ERROR(400, "请求参数错误"),
    UNAUTHORIZED(401, "暂未登录或登录已过期"),
    FORBIDDEN(403, "没有相关权限"),
    NOT_FOUND(404, "没有找到请求资源");

	/**
	 * 状态码
	 */
	@Getter
	private int code;

	/**
	 * 提示信息
	 */
    @Getter
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
