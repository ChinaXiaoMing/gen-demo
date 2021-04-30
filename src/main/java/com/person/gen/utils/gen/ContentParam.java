package com.person.gen.utils.gen;

import com.person.gen.dto.ColumnInfoDTO;
import com.person.gen.query.GenParam;
import com.person.gen.utils.StrUtils;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * freemarker代码生成基础填充参数
 *
 * @author fu.yuanming
 * @since 2021-01-23
 */
@Data
@NoArgsConstructor
public class ContentParam {

	@ApiModelProperty("包名称")
	private String packageName;
	@ApiModelProperty("功能描述")
	private String description;
	@ApiModelProperty("作者")
	private String author;
	@ApiModelProperty("创建日期")
	private String fileCreateTime;
	@ApiModelProperty("类名")
	private String className;

	@ApiModelProperty("变量名称")
	private String variableName;
	@ApiModelProperty("主键字段信息")
	private ColumnInfoDTO keyColumnInfo;
	@ApiModelProperty("所有字段信息")
	private List<ColumnInfoDTO> columnInfoList;
	@ApiModelProperty("表名称")
	private String tableName;
	@ApiModelProperty("原始表名称")
	private String originTableName;

	@ApiModelProperty("Date Java类型")
	private String dateJavaType;
	@ApiModelProperty("BigDecimal Java类型")
	private String bigDecimalJavaType;

	public ContentParam(GenParam genParam) {
		this.packageName = genParam.getPackageName();
		this.description = genParam.getDescription();
		this.author = genParam.getAuthor();
		this.fileCreateTime = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
		this.className = StrUtils.convertToClassName(genParam.getTableName());
	}

}
