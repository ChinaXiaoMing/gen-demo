package com.person.gen.service.impl;

import com.person.gen.common.Result;
import com.person.gen.common.convert.JavaColumnTypeConverter;
import com.person.gen.config.GenConfig;
import com.person.gen.constant.Constant;
import com.person.gen.dto.ColumnInfoDTO;
import com.person.gen.entity.ColumnInfo;
import com.person.gen.entity.TableInfo;
import com.person.gen.mapper.GeneratorMapper;
import com.person.gen.query.GenParam;
import com.person.gen.service.GeneratorService;
import com.person.gen.utils.StrUtils;
import com.person.gen.utils.gen.FreeMarkerUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 自动生成代码逻辑实现
 *
 * @author fu.yuanming
 * @since 2021-01-21
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GeneratorServiceImpl implements GeneratorService {

	private final GeneratorMapper generatorMapper;

	private final GenConfig genConfig;


	@Override
	public List<ColumnInfo> qryColumnInfoList(GenParam genParam) {
		return generatorMapper.selectColumnInfoByTableName(genParam.getTableName());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Result<String> generateCode(GenParam genParam) {
		List<ColumnInfo> columnInfos = qryColumnInfoList(genParam);
		if (CollectionUtils.isEmpty(columnInfos)) {
			log.error("{}数据库表不存在", genParam.getTableName());
			return Result.error(genParam.getTableName() + "数据库表不存在");
		}
		List<ColumnInfoDTO> columnInfoList = buildColumnInfo(columnInfos);
		// 处理自动生成代码前端配置参数
		processGenParam(genParam);
		// 自动生成后端代码
		try {
			FreeMarkerUtils.genServerCode(genParam, columnInfoList);
		} catch (IOException e) {
			log.error("生成代码发生错误", e);
			return Result.error("生成代码发生错误");
		}
		return Result.success("代码生成成功");
	}


	/**
	 * 处理自动生成代码前端配置参数
	 *
	 * @param genParam 自动生成代码参数
	 */
	private void processGenParam(GenParam genParam) {
		// 保存前端原始表名称
		genParam.setOriginTableName(genParam.getTableName());
		// 设置作者，不设置默认为配置文件中的配置
		if (StringUtils.isEmpty(genParam.getAuthor())) {
			genParam.setAuthor(genConfig.getAuthor());
		}
		// 设置包名称，不设置默认为配置文件中的配置
		if (StringUtils.isEmpty(genParam.getPackageName())) {
			genParam.setPackageName(genConfig.getPackageName());
		}
		// 设置功能描述，不设置默认使用数据库表注释
		processDescription(genParam);
		// 忽略前缀
		processPrefix(genParam);

		if (StringUtils.isEmpty(genParam.getProjectPath())) {
			genParam.setProjectPath(genConfig.getProjectPath());
		}
		genParam.setJavaPath(genConfig.getJavaPath());
		genParam.setSourcePath(genConfig.getSourcePath());
	}

	private void processDescription(GenParam genParam) {
		if (StringUtils.isEmpty(genParam.getDescription())) {
			TableInfo tableInfo = generatorMapper.selectTableInfoByTableName(genParam.getTableName());
			if (tableInfo != null) {
				String tableComment = tableInfo.getTableComment();
				if (StringUtils.isNotEmpty(tableComment) && tableComment.contains(Constant.COMMENT_SUFFIX)) {
					genParam.setDescription(tableComment.substring(0, tableComment.length() - 1));
				} else {
					genParam.setDescription(tableComment);
				}
			}
		}
	}

	private void processPrefix(GenParam genParam) {
		String tableName = genParam.getTableName();
		String ignorePrefix = genParam.getIgnorePrefix();
		if (StringUtils.isNotEmpty(ignorePrefix)) {

			if (ignorePrefix.contains(Constant.UNDERLINE)) {
				genParam.setTableName(tableName.substring(ignorePrefix.length()));
			}
			// 忽略前缀不包含下划线时
			else {
				genParam.setTableName(tableName.substring(ignorePrefix.length() + 1));
			}
		}
	}

	private List<ColumnInfoDTO> buildColumnInfo(List<ColumnInfo> columnInfoList) {
		List<ColumnInfoDTO> columnInfoDTOList = new ArrayList<>();
		for (ColumnInfo columnInfo : columnInfoList) {
			ColumnInfoDTO columnInfoDTO = new ColumnInfoDTO();
			columnInfoDTO.setColumnModelName(StrUtils.convertToCamelCase(columnInfo.getColumnName()));
			columnInfoDTO.setJavaType(JavaColumnTypeConverter.convertJavaBoxType(columnInfo.getDataType()));
			columnInfoDTO.setColumnName(columnInfo.getColumnName());
			columnInfoDTO.setColumnKey(columnInfo.getColumnKey());
			columnInfoDTO.setColumnComment(columnInfo.getColumnComment());
			columnInfoDTO.setDataType(columnInfo.getDataType());
			columnInfoDTO.setIsNullable(columnInfo.getIsNullable());
			columnInfoDTO.setExtra(columnInfo.getExtra());
			columnInfoDTOList.add(columnInfoDTO);
		}
		return columnInfoDTOList;
	}

}
