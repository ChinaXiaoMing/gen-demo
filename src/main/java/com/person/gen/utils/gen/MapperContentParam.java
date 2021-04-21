package com.person.gen.utils.gen;

import com.person.gen.dto.ColumnInfoDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author fu.yuanming
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MapperContentParam extends BaseContentParam {

	@ApiModelProperty("变量名称")
	private String variableName;

	@ApiModelProperty("主键字段信息")
	private ColumnInfoDTO keyColumnInfo;

}
