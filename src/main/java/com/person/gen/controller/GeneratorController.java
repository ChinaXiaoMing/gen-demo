package com.person.gen.controller;

import com.person.gen.common.Result;
import com.person.gen.entity.ColumnInfo;
import com.person.gen.query.GenParam;
import com.person.gen.service.GeneratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自动生成代码管理
 *
 * @author fu.yuanming
 * @since 2021-01-20
 */
@RestController
@RequestMapping(value = "gen")
@RequiredArgsConstructor
@Api(tags = "自动生成代码API")
public class GeneratorController {

  private final GeneratorService generatorService;

  @ApiOperation(value = "获取表字段信息", notes = "获取表字段信息")
  @GetMapping("qryColumnInfoList")
  public Result<List<ColumnInfo>> qryColumnInfoList(GenParam genParam) {
    return Result.success(generatorService.qryColumnInfoList(genParam));
  }

  @ApiOperation(value = "根据表名称自动生成代码", notes = "根据表名称自动生成代码")
  @GetMapping("generateCode")
  public Result<Boolean> generateCode(GenParam genParam) {
    return Result.success(generatorService.generateCode(genParam));
  }

}
