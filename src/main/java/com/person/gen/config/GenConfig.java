package com.person.gen.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 自动代码生成配置类
 *
 * @author fu.yuanming
 * @since 2021-04-22
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "gen")
public class GenConfig {
	// 作者
	private String author;
	// 包名称
	private String packageName;

}
