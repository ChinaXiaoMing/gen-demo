package com.person.gen.service.impl;

import com.github.pagehelper.PageInfo;
import com.person.gen.dto.LoginLogPageQuery;
import com.person.gen.entity.LoginLog;
import com.person.gen.mapper.LoginLogMapper;
import com.person.gen.service.ILoginLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 登录日志逻辑实现
 *
 * @author fu.yuanming
 * @since 2021-01-06
 */
@Service
@RequiredArgsConstructor
public class LoginLogServiceImpl implements ILoginLogService {

  private final LoginLogMapper loginLogMapper;

  @Override
  public Integer addLoginLog(LoginLog loginLog) {
    return loginLogMapper.insertLoginLog(loginLog);
  }

  @Override
  public Integer modLoginLog(LoginLog loginLog) {
    return loginLogMapper.updateLoginLog(loginLog);
  }

  @Override
  public Integer delLoginLog(Integer id) {
    return loginLogMapper.deleteLoginLog(id);
  }

  @Override
  public LoginLog qryLoginLog(Integer id) {
    return loginLogMapper.selectLoginLog(id);
  }

  @Override
  public PageInfo<LoginLog> qryLoginLogPage(LoginLogPageQuery loginLogPageQuery) {
    return loginLogMapper.selectLoginLogPage(loginLogPageQuery, loginLogPageQuery.buildRowBounds()).toPageInfo();
  }

}
