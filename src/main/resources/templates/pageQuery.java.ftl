package ${packageName}.query;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
* ${description}分页查询参数
*
* @author ${author}
* @since ${fileCreateTime}
*/
@Data
public class ${className}PageQuery extends PageQueryParams {
<#list columnInfoList as columnInfo>
    @ApiModelProperty("${columnInfo.columnComment}")
    private ${columnInfo.javaType} ${columnInfo.columnModelName};

</#list>
}
