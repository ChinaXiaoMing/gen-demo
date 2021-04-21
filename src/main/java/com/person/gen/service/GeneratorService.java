package com.person.gen.service;

import com.person.gen.entity.ColumnInfo;
import com.person.gen.query.GenConfig;
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
	 * @param genConfig 表名称
	 * @return 字段信息
	 */
	List<ColumnInfo> qryColumnInfoList(GenConfig genConfig);

	/**
	 * 自动生成代码
	 *
	 * @param genConfig 表名称
	 * @return 是否成功
	 */
	Boolean generateCode(GenConfig genConfig);

}
