package ${packageName}.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
* ${description}
*
* @author ${author}
* @since ${fileCreateTime}
*/
@Data
@ApiModel("${originTableName}")
public class ${className} {

    <#list columnInfoList as columnInfo>
    @ApiModelProperty("${columnInfo.columnComment}")
    private ${columnInfo.javaType} ${columnInfo.columnModelName};

    </#list>
}
