package ${packageName}.service.impl;

import com.github.pagehelper.PageInfo;
import ${packageName}.query.${className}PageQuery;
import ${packageName}.model.${className};
import ${packageName}.mapper.${className}Mapper;
import ${packageName}.service.I${className}Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* ${description}管理
*
* @author ${author}
* @since ${fileCreateTime}
*/
@Service
@RequiredArgsConstructor
public class ${className}ServiceImpl implements I${className}Service {

    private final ${className}Mapper ${variableName}Mapper;

    @Override
    public Integer add${className}(${className} ${variableName}) {
        return ${variableName}Mapper.insert${className}(${variableName});
    }

    @Override
    public Integer mod${className}(${className} ${variableName}) {
        return ${variableName}Mapper.update${className}(${variableName});
    }

    @Override
    public Integer del${className}(${keyColumnInfo.javaType} ${keyColumnInfo.columnModelName}) {
        return ${variableName}Mapper.delete${className}(${keyColumnInfo.columnModelName});
    }

    @Override
    public ${className} qry${className}(${keyColumnInfo.javaType} ${keyColumnInfo.columnModelName}) {
        return ${variableName}Mapper.select${className}(${keyColumnInfo.columnModelName});
    }

    @Override
    public PageInfo<${className}> qry${className}Page(${className}PageQuery ${variableName}PageQuery) {
        return ${variableName}Mapper.select${className}Page(${variableName}PageQuery, ${variableName}PageQuery.buildRowBounds()).toPageInfo();
    }

}