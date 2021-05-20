package ${packageName}.query;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* ${description}分页查询参数
*
* @author ${author}
* @since ${fileCreateTime}
*/
@Data
@EqualsAndHashCode(callSuper = true)
public class ${className}PageQuery extends BasePageQueryParams {
<#list columnInfoList as columnInfo>
    @ApiModelProperty("${columnInfo.columnComment}")
    private ${columnInfo.javaType} ${columnInfo.columnModelName};

</#list>
}
