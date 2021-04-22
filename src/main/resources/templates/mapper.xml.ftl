<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.mapper.${className}Mapper">

    <sql id="${variableName}Columns">
        <#list columnInfoList as columnInfo>${columnInfo.columnName}<#sep>, </#list>
    </sql>

    <!-- 新增${description} -->
    <insert id="insert${className}" useGeneratedKeys="true" keyColumn="${keyColumnInfo.columnName}">
        INSERT INTO ${originTableName}(
        <#list columnInfoList as columnInfo>
        <#if columnInfo.columnKey == 'null' || columnInfo.columnKey == ''>
        ${columnInfo.columnName}<#sep>,
        </#if>
        </#list>

        )
        VALUES (
        <#list columnInfoList as columnInfo>
        <#if columnInfo.columnKey == 'null' || columnInfo.columnKey == ''>
        <#noparse>#{</#noparse>${columnInfo.columnModelName}<#noparse>}</#noparse><#sep>,
        </#if>
        </#list>

        )
    </insert>

    <!-- 更新${description} -->
    <update id="update${className}">
        UPDATE ${originTableName}
        <set>
            <#list columnInfoList as columnInfo>
            <#if columnInfo.javaType == "String">
            <if test="${columnInfo.columnModelName} != null and ${columnInfo.columnModelName} != ''">
                ${columnInfo.columnName} = <#noparse>#{</#noparse>${columnInfo.columnModelName}<#noparse>}</#noparse><#sep>,
            </if>
            <#else>
            <if test="${columnInfo.columnModelName} != null">
                ${columnInfo.columnName} = <#noparse>#{</#noparse>${columnInfo.columnModelName}<#noparse>}</#noparse><#sep>,
            </if>
            </#if>
            </#list>

            </if>
        </set>
        WHERE ${keyColumnInfo.columnName} = <#noparse>#{</#noparse>${keyColumnInfo.columnModelName}<#noparse>}</#noparse>
    </update>

    <!-- 删除${description} -->
    <delete id="delete${className}">
        DELETE FROM ${originTableName} WHERE ${keyColumnInfo.columnName} = <#noparse>#{</#noparse>${keyColumnInfo.columnModelName}<#noparse>}</#noparse>
    </delete>

    <!-- 根据 ID 查询单条${description}数据 -->
    <select id="select${className}" resultType="${packageName}.model.${className}">
        SELECT
        <include refid="${variableName}Columns"/>
        FROM ${originTableName} WHERE ${keyColumnInfo.columnName} = <#noparse>#{</#noparse>${keyColumnInfo.columnModelName}<#noparse>}</#noparse>
    </select>

    <!-- 查询${description}列表数据（分页） -->
    <select id="select${className}Page" resultType="${packageName}.model.${className}">
        SELECT
        <include refid="${variableName}Columns"/>
        FROM ${originTableName}
    </select>

</mapper>