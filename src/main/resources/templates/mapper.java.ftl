package ${packageName}.mapper;

import com.github.pagehelper.Page;
import ${packageName}.query.${className}PageQuery;
import ${packageName}.model.${className};
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
* ${description}管理 Mapper
*
* @author ${author}
* @since ${fileCreateTime}
*/
@Mapper
public interface ${className}Mapper {

    ${className} select${className}(@Param("${keyColumnInfo.columnModelName}") ${keyColumnInfo.javaType} ${keyColumnInfo.columnModelName});

    Page<${className}> select${className}Page(${className}PageQuery ${variableName}PageQuery, RowBounds rowBounds);

    Integer insert${className}(${className} ${variableName});

    Integer update${className}(${className} ${variableName});

    Integer delete${className}(@Param("${keyColumnInfo.columnModelName}") ${keyColumnInfo.javaType} ${keyColumnInfo.columnModelName});

}