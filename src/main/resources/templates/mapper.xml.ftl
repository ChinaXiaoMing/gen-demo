<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.person.gen.mapper.LoginLogMapper">

    <sql id="loginLogColumns">
        id,login_name,ip,login_status,login_time,spend_time,browser_name,browser_type,browser_version,operation_system,remark
    </sql>

    <!-- 新增登录日志 -->
    <insert id="insertLoginLog" useGeneratedKeys="true" keyColumn="id">
        INSERT INTO login_log(
        <include refid="loginLogColumns"/>
        )
        VALUES (
        #{loginLog.id},
        #{loginLog.loginName},
        #{loginLog.ip},
        #{loginLog.loginStatus},
        #{loginLog.loginTime},
        #{loginLog.spendTime},
        #{loginLog.browserName},
        #{loginLog.browserType},
        #{loginLog.browserVersion},
        #{loginLog.oprationSystem},
        #{loginLog.remark}
        )
    </insert>

    <!-- 更新登录日志 -->
    <update id="updateLoginLog">
        UPDATE login_log
        <set>
            <if test="remark != null and remark != ''">
                remark = #{loginLog.remark}
            </if>
        </set>
        WHERE id = #{loginLog.id}
    </update>

    <!-- 删除登录日志 -->
    <delete id="deleteLoginLog">
        DELETE FROM login_log WHERE id = #{id}
    </delete>

    <!-- 根据 ID 查询单条登录日志数据 -->
    <select id="selectLoginLog" resultType="com.person.gen.entity.LoginLog">
        SELECT
        <include refid="loginLogColumns"/>
        FROM login_log WHERE id = #{id}
    </select>
    <!-- 查询登录日志列表数据（分页） -->
    <select id="selectLoginLogPage" resultType="com.person.gen.entity.LoginLog">
        SELECT
        <include refid="loginLogColumns"/>
        FROM login_log
    </select>

</mapper>