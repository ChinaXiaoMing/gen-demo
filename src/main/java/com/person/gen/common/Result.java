package com.person.gen.common;

import java.io.Serializable;
import lombok.Data;

/**
 * 通用结果处理类
 *
 * @author xiaoming
 * @since 2020/3/21 12:27
 **/
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    //状态码
    private int code;
    //提示信息
    private String message;
    //操作成功时获取的响应数据
    private T data;

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
   * 操作成功
   *
   * @return Result<T>
   */
  public static <T> Result<T> success() {
    return success(ResultCode.SUCCESS.getMessage());
  }

  /**
   * 操作成功
   *
   * @param message 提升信息
   * @return Result<T>
   */
  public static <T> Result<T> success(String message) {
    return new Result<>(ResultCode.SUCCESS.getCode(), message);
  }

    /**
     * 操作成功返回结果
     *
     * @param data 操作成功获取的响应数据
     * @return Result<T>
     */
    public static <T> Result<T> success(T data) {
        return success(ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 操作成功返回结果
     *
     * @param message 操作成功提示信息
     * @param data 操作成功获取的响应数据
     * @return Result<T>
     */
    public static <T> Result<T> success(String message, T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 操作失败返回结果
     *
     * @return Result<T>
     */
    public static <T> Result<T> failure() {
        return failure(ResultCode.FAILED.getMessage());
    }

    /**
     * 操作失败返回结果
     *
     * @param message 错误提示信息
     * @return Result<T>
     */
    public static <T> Result<T> failure(String message) {
        return failure(ResultCode.FAILED.getCode(), message);
    }

    /**
     * 操作失败返回结果
     *
     * @param code 错误码
     * @param message 错误提示信息
     * @return Result<T>
     */
    public static <T> Result<T> failure(int code, String message) {
        return new Result<>(code, message, null);
    }

}
