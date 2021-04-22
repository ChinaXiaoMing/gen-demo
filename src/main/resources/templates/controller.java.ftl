package ${packageName}.controller;

import com.github.pagehelper.PageInfo;
import ${packageName}.common.Result;
import ${packageName}.query.${className}PageQuery;
import ${packageName}.model.${className};
import ${packageName}.service.I${className}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
* ${description}管理
*
* @author ${author}
* @since ${fileCreateTime}
*/
@RestController
@RequestMapping(value = "/${variableName}")
@RequiredArgsConstructor
@Api(tags = "${description}管理API")
public class ${className}Controller {

    private final I${className}Service ${variableName}Service;

    @ApiOperation("根据 ID 查询单条${description}数据")
    @GetMapping("qry${className}ById")
    public Result<${className}> qry${className}ById(@ApiParam(value = "${keyColumnInfo.columnComment}") @RequestParam ${keyColumnInfo.javaType} ${keyColumnInfo.columnModelName}) {
        return Result.success(${variableName}Service.qry${className}(${keyColumnInfo.columnModelName}));
    }

    @ApiOperation("查询${description}列表数据（分页）")
    @PostMapping("qry${className}Page")
    public Result<PageInfo<${className}>> qry${className}Page(@RequestBody ${className}PageQuery ${variableName}PageQuery) {
        return Result.success(${variableName}Service.qry${className}Page(${variableName}PageQuery));
    }

    @ApiOperation("新增${description}")
    @PostMapping("add${className}")
    public Result<Integer> add${className}(@RequestBody ${className} ${variableName}) {
        return Result.success(${variableName}Service.add${className}(${variableName}));
    }

    @ApiOperation("更新${description}")
    @PostMapping("mod${className}")
    public Result<Integer> mod${className}(@RequestBody ${className} ${variableName}) {
        return Result.success(${variableName}Service.mod${className}(${variableName}));
    }

    @ApiOperation("删除${description}")
    @PostMapping("del${className}")
    public Result<Integer> del${className}(@ApiParam(value = "${keyColumnInfo.columnComment}") @RequestParam ${keyColumnInfo.javaType} ${keyColumnInfo.columnModelName}) {
        return Result.success(${variableName}Service.del${className}(${keyColumnInfo.columnModelName}));
    }

}
