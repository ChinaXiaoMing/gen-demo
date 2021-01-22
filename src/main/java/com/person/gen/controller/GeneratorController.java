package com.person.gen.controller;

import com.person.gen.common.Result;
import com.person.gen.entity.TableInfo;
import com.person.gen.service.GeneratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自动生成代码管理
 *
 * @author fu.yuanming
 * @since 2021-01-20
 */
@RestController
@RequestMapping(value = "generator")
@RequiredArgsConstructor
@Api(tags = "自动生成代码 API")
public class GeneratorController {

  private final GeneratorService generatorService;

  @ApiOperation(value = "根据表名称获取表数据", notes = "根据表名称获取表数据")
  @GetMapping("queryTableInfoByTableName")
  public Result<TableInfo> queryTableInfoByTableName(@RequestParam String tableName) {
    return Result.success(generatorService.queryTableInfoByTableName(tableName));
  }

}
