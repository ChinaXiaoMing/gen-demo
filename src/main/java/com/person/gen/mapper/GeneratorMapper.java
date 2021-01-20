package com.person.gen.mapper;

import com.person.gen.entity.TableInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GeneratorMapper {

  TableInfo selectTableInfoByTableName(@Param("tableName") String tableName);

}
