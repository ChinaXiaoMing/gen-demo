package com.person.gen.common;

import java.io.Serializable;
import lombok.Data;

/**
 * 通用结果处理类
 *
 * @author fu.yuanming
 * @since 2020/3/21
 */
@Data
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 操作成功默认提示信息
	 */
	private static final String DEFAULT_SUCCESS_MSG = "操作成功";
	/**
	 * 操作成功默认状态码
	 */
	private static final int DEFAULT_SUCCESS_CODE = 200;
	/**
	 * 操作失败默认提示信息
	 */
	private static final String DEFAULT_ERROR_MSG = "操作失败";
	/**
	 * 操作失败默认状态码
	 */
	private static final int DEFAULT_ERROR_CODE = 500;
	/**
	 * 状态码
	 */
	private int code;
	/**
	 * 提示信息
	 */
	private String message;
	/**
	 * 操作成功时获取的响应数据
	 */
	private transient T data;

	public Result(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public Result(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * 操作成功返回结果
	 *
	 * @return Result<T>
	 */
	public static <T> Result<T> success() {
		return new Result<>(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG);
	}

	/**
	 * 操作成功返回结果
	 *
	 * @param message 操作成功提示信息
	 * @return Result<T>
	 */
	public static <T> Result<T> success(String message) {
		return new Result<>(DEFAULT_SUCCESS_CODE, message);
	}

	/**
	 * 操作成功返回结果
	 *
	 * @param data 操作成功获取的响应数据
	 * @return Result<T>
	 */
	public static <T> Result<T> success(T data) {
		return success(DEFAULT_SUCCESS_MSG, data);
	}

	/**
	 * 操作成功返回结果
	 *
	 * @param message 操作成功提示信息
	 * @param data    操作成功获取的响应数据
	 * @return Result<T>
	 */
	public static <T> Result<T> success(String message, T data) {
		return new Result<>(DEFAULT_SUCCESS_CODE, message, data);
	}

	/**
	 * 操作失败返回结果
	 *
	 * @return Result<T>
	 */
	public static <T> Result<T> error() {
		return error(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG);
	}

	/**
	 * 操作失败返回结果
	 *
	 * @param message 错误提示信息
	 * @return Result<T>
	 */
	public static <T> Result<T> error(String message) {
		return error(DEFAULT_ERROR_CODE, message);
	}

	/**
	 * 操作失败返回结果
	 *
	 * @param code    错误码
	 * @param message 错误提示信息
	 * @return Result<T>
	 */
	public static <T> Result<T> error(int code, String message) {
		return new Result<>(code, message);
	}

}
