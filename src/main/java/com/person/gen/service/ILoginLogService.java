package com.person.gen.service;

import com.github.pagehelper.PageInfo;
import com.person.gen.dto.LoginLogPageQuery;
import com.person.gen.entity.LoginLog;

/**
 * 登录日志接口
 *
 * @author fu.yuanming
 * @since 2021-01-05
 */
public interface ILoginLogService {

  /**
   * 新增登录日志
   *
   * @param loginLog 登录日志
   * @return 操作记录数
   */
  Integer addLoginLog(LoginLog loginLog);

  /**
   * 修改登录日志
   *
   * @param loginLog 登录日志
   * @return 操作记录数
   */
  Integer modLoginLog(LoginLog loginLog);

  /**
   * 删除登录日志
   *
   * @param id 登录日志 ID
   * @return 操作记录数
   */
  Integer delLoginLog(Integer id);

  /**
   * 根据 ID 查询单条登录日志
   *
   * @param id 登录日志 ID
   * @return 登录日志
   */
  LoginLog qryLoginLog(Integer id);

  /**
   * 查询登录日志列表数据（分页）
   *
   * @param loginLogPageQuery 分页查询参数
   * @return 登录日志列表数据
   */
  PageInfo<LoginLog> qryLoginLogPage(LoginLogPageQuery loginLogPageQuery);

}
