package com.person.gen.service;

import com.person.gen.entity.ColumnInfo;
import com.person.gen.query.GenParam;
import java.util.List;

/**
 * 自动生成代码接口
 *
 * @author fu.yuanming
 * @since 2021-01-21
 */
public interface GeneratorService {

	/**
	 * 获取字段信息
	 *
	 * @param genParam 表名称
	 * @return 字段信息
	 */
	List<ColumnInfo> qryColumnInfoList(GenParam genParam);

	/**
	 * 自动生成代码
	 *
	 * @param genParam 表名称
	 * @return 代码生成是否成功
	 */
	Boolean generateCode(GenParam genParam);

}
