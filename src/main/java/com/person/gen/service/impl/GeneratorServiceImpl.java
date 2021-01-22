package com.person.gen.service.impl;

import com.person.gen.entity.TableInfo;
import com.person.gen.mapper.GeneratorMapper;
import com.person.gen.service.GeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 自动生成代码逻辑实现
 *
 * @author fu.yuanming
 * @since 2021-01-21
 */
@Service
@RequiredArgsConstructor
public class GeneratorServiceImpl implements GeneratorService {

  private final GeneratorMapper generatorMapper;

  @Override
  public TableInfo queryTableInfoByTableName(String tableName) {
    return generatorMapper.selectTableInfoByTableName(tableName);
  }

}
