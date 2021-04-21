package com.person.gen.utils.gen;

import com.person.gen.dto.ColumnInfoDTO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author fu.yuanming
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ModelContentParam extends BaseContentParam {

	@ApiModelProperty("字段信息")
	private List<ColumnInfoDTO> columnInfoList;

	@ApiModelProperty("表名称")
	private String tableName;

}
