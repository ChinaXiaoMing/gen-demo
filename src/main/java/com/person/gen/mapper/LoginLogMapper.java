package com.person.gen.mapper;

import com.github.pagehelper.Page;
import com.person.gen.dto.LoginLogPageQuery;
import com.person.gen.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 登录日志Mapper接口
 *
 * @author fu.yuanming
 * @since 2021-01-05
 */
@Mapper
public interface LoginLogMapper {

  LoginLog selectLoginLog(@Param("id") Integer id);

  Page<LoginLog> selectLoginLogPage(LoginLogPageQuery loginLogPageQuery, RowBounds rowBounds);

  Integer insertLoginLog(LoginLog loginLog);

  Integer updateLoginLog(LoginLog loginLog);

  Integer deleteLoginLog(@Param("id") Integer id);

}
