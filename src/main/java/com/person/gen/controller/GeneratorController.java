package com.person.gen.controller;

import com.person.gen.common.Result;
import com.person.gen.entity.TableInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fu.yuanming
 * @since 2021-01-20
 */
@RestController
@RequestMapping("generator")
@Api(tags = "自动生成代码 API")
public class GeneratorController {

  @ApiOperation(value = "根据表名称获取表数据", notes = "根据表名称获取表数据")
  public Result<TableInfo> queryTableInfoByTableName(@RequestParam String tableName) {
    return Result.success();
  }

}
