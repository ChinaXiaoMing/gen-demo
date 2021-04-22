package ${packageName}.service;

import com.github.pagehelper.PageInfo;
import ${packageName}.query.${className}PageQuery;
import ${packageName}.model.${className};

/**
* ${description}接口
*
* @author ${author}
* @since ${fileCreateTime}
*/
public interface I${className}Service {

    /**
    * 新增${description}
    *
    * @param ${variableName} ${description}
    * @return 操作记录数
    */
    Integer add${className}(${className} ${variableName});

    /**
    * 修改${description}
    *
    * @param ${variableName} ${description}
    * @return 操作记录数
    */
    Integer mod${className}(${className} ${variableName});

    /**
    * 删除${description}
    *
    * @param ${keyColumnInfo.columnModelName} ${description} ID
    * @return 操作记录数
    */
    Integer del${className}(${keyColumnInfo.javaType} ${keyColumnInfo.columnModelName});

    /**
    * 根据 ID 查询单条${description}数据
    *
    * @param ${keyColumnInfo.columnModelName} ${description} ID
    * @return ${description}
    */
    ${className} qry${className}(${keyColumnInfo.javaType} ${keyColumnInfo.columnModelName});

    /**
    * 查询${description}列表数据（分页）
    *
    * @param ${variableName}PageQuery 分页查询参数
    * @return ${description}列表数据
    */
    PageInfo<${className}> qry${className}Page(${className}PageQuery ${variableName}PageQuery);

}
