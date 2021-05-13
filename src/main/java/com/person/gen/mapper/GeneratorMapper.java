package com.person.gen.mapper;

import com.person.gen.entity.ColumnInfo;
import com.person.gen.entity.TableInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 自动代码生成Mapper接口
 *
 * @author fu.yuanming
 * @since 2021-01-05
 */
@Mapper
public interface GeneratorMapper {

	TableInfo selectTableInfoByTableName(@Param("tableName") String tableName);

	List<ColumnInfo> selectColumnInfoByTableName(@Param("tableName") String tableName);

}
