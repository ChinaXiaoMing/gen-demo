package com.person.gen.service.impl;

import com.person.gen.common.convert.JavaColumnTypeConverter;
import com.person.gen.dto.ColumnInfoDTO;
import com.person.gen.entity.ColumnInfo;
import com.person.gen.mapper.GeneratorMapper;
import com.person.gen.query.GenConfig;
import com.person.gen.service.GeneratorService;
import com.person.gen.utils.FreeMarkerUtils;
import com.person.gen.utils.StrUtils;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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


	@Override
	public List<ColumnInfo> qryColumnInfoList(GenConfig genConfig) {
		return generatorMapper.selectColumnInfoByTableName(genConfig.getTableName());
	}

	@Override
	public Boolean generateCode(GenConfig genConfig) {
		List<ColumnInfo> columnInfoList = qryColumnInfoList(genConfig);
		List<ColumnInfoDTO> columnInfoDTOList = buildColumnInfo(columnInfoList);
		FreeMarkerUtils.genCode(genConfig, columnInfoDTOList);
		return true;
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
