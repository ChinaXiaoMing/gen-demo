package com.person.gen.utils;

import com.person.gen.dto.ColumnInfoDTO;
import com.person.gen.query.GenConfig;
import com.person.gen.utils.gen.BaseContentParam;
import com.person.gen.utils.gen.MapperContentParam;
import com.person.gen.utils.gen.ModelContentParam;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;

/**
 * @author fu.yuanming
 * @since 2020/4/4 10:22
 **/
@Slf4j
public class FreeMarkerUtils {

	private static final String JAVA_DIR = System.getProperty("user.dir") + "/src/main/java/com/person/gen";

	private static final String RESOURCE_DIR = System.getProperty("user.dir") + "/src/main/resources";

	@Data
	private static class ConfigParams {

		private File generateFile;

		private String TemplateFileName;

		private String className;

	}

	public static Boolean genCode(GenConfig genConfig, List<ColumnInfoDTO> columnInfoList) {
//		genMapperXmlFile(genConfig.getTableName());
		ColumnInfoDTO keyColumnInfo = columnInfoList.stream().filter(column -> StringUtils.isNotEmpty(column.getColumnKey()))
				.collect(Collectors.toList()).get(0);
		log.info("keyInfo: {}", keyColumnInfo);
		genMapperInterface(genConfig, keyColumnInfo);
//		genModelClass(genConfig, columnInfoList);
		return Boolean.TRUE;
	}

	public static void genMapperXmlFile(GenConfig genConfig) {
		ConfigParams params = new ConfigParams();
		params.setGenerateFile(new File(RESOURCE_DIR + "/mapper/" + convertClassName(genConfig) + "Mapper.xml"));
		params.setTemplateFileName("mapper.xml.ftl");
		configGenerate(params, new BaseContentParam());
	}

	public static void genMapperInterface(GenConfig genConfig, ColumnInfoDTO columnInfo) {
		ConfigParams params = new ConfigParams();
		String className = convertClassName(genConfig);
		params.setGenerateFile(new File(JAVA_DIR + "/mapper/" + className + "Mapper.java"));
		params.setTemplateFileName("mapper.java.ftl");

		MapperContentParam mapperContentParam = new MapperContentParam();
		mapperContentParam.setPackageName("com.person.gen");
		mapperContentParam.setDescription(genConfig.getDescription());
		mapperContentParam.setVariableName(StrUtils.toLowerCaseFirst(className));
		mapperContentParam.setClassName(className);
		mapperContentParam.setKeyColumnInfo(columnInfo);

		configGenerate(params, mapperContentParam);
	}

	public static void genModelClass(GenConfig genConfig, List<ColumnInfoDTO> columnInfoList) {
		ConfigParams configParams = new ConfigParams();
		String className = convertClassName(genConfig);
		configParams.setGenerateFile(new File(JAVA_DIR + "/model/" + className + ".java"));
		configParams.setTemplateFileName("model.java.ftl");

		ModelContentParam modelContentParam = new ModelContentParam();
		modelContentParam.setColumnInfoList(columnInfoList);
		modelContentParam.setClassName(className);
		configGenerate(configParams, modelContentParam);
	}

	private static String convertClassName(GenConfig genConfig) {
		return StrUtils.convertToClassName(genConfig.getTableName());
	}

	private static void configGenerate(ConfigParams configParams, BaseContentParam params) {
		// 1.创建freemarker配置
		Configuration configuration = new Configuration(Configuration.getVersion());
		// 2.设置字符集
		configuration.setDefaultEncoding("utf-8");
		try {
			// 3.设置模板文件所在路径
			configuration.setDirectoryForTemplateLoading(ResourceUtils.getFile("classpath:templates"));
			// 4.指定模板文件
			Template template = configuration.getTemplate(configParams.getTemplateFileName());

			try (Writer writer = new FileWriter(configParams.getGenerateFile())) {
				template.process(params, writer);
				log.info("模板文件解析成功，生成文件: {}", configParams.getGenerateFile().getName());
			} catch (TemplateException e) {
				e.printStackTrace();
				log.error("模板文件解析发生错误！错误信息: {}", e.getMessage());
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.error("模板文件或目录不存在！");
		}
	}

}
