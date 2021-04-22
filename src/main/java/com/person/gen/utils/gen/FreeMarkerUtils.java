package com.person.gen.utils.gen;

import static freemarker.template.Configuration.VERSION_2_3_30;
import com.person.gen.dto.ColumnInfoDTO;
import com.person.gen.query.GenParam;
import com.person.gen.utils.StrUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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

	}

	public static Boolean genServerCode(GenParam genParam, List<ColumnInfoDTO> columnInfoList) {
		// 生成controller文件
		genControllerFile(genParam, columnInfoList);
		// 生成service接口文件
		genServiceFile(genParam, columnInfoList);
		// 生成serviceImpl接口实现类文件
		genServiceImplFile(genParam, columnInfoList);
		// 生成分页查询参数文件
		genPageQueryFile(genParam, columnInfoList);
		// 生成mapper接口文件
		genMapperFile(genParam, columnInfoList);
		// 生成mapper.xml文件
		genMapperXmlFile(genParam, columnInfoList);
		// 生成实体类文件
		genModelFile(genParam, columnInfoList);
		return Boolean.TRUE;
	}

	public static void genControllerFile(GenParam genParam, List<ColumnInfoDTO> columnInfoList) {
		String className = StrUtils.convertToClassName(genParam.getTableName());

		String genFileName = JAVA_DIR + "/" + "controller" + "/" + className + "Controller.java";

		ConfigParams params = buildConfigParams(genFileName, "controller.java.ftl");
		ContentParam contentParam = initContentParam(genParam, columnInfoList, className);

		freemarkerGenerate(params, contentParam);
	}

	public static void genServiceFile(GenParam genParam, List<ColumnInfoDTO> columnInfoList) {
		String className = StrUtils.convertToClassName(genParam.getTableName());
		String genFileName = JAVA_DIR + "/" + "service" + "/I" + className + "Service.java";

		ConfigParams params = buildConfigParams(genFileName, "service.java.ftl");
		ContentParam contentParam = initContentParam(genParam, columnInfoList, className);

		freemarkerGenerate(params, contentParam);
	}

	public static void genServiceImplFile(GenParam genParam, List<ColumnInfoDTO> columnInfoList) {
		String className = StrUtils.convertToClassName(genParam.getTableName());
		String genFileName = JAVA_DIR + "/" + "service/impl" + "/" + className + "ServiceImpl.java";

		ConfigParams params = buildConfigParams(genFileName, "serviceImpl.java.ftl");
		ContentParam contentParam = initContentParam(genParam, columnInfoList, className);

		freemarkerGenerate(params, contentParam);
	}

	public static void genPageQueryFile(GenParam genParam, List<ColumnInfoDTO> columnInfoList) {
		String className = StrUtils.convertToClassName(genParam.getTableName());
		String genFileName = JAVA_DIR + "/" + "query" + "/" + className + "PageQuery.java";

		ConfigParams params = buildConfigParams(genFileName, "pageQuery.java.ftl");
		ContentParam contentParam = initContentParam(genParam, columnInfoList, className);

		freemarkerGenerate(params, contentParam);
	}

	public static void genMapperFile(GenParam genParam, List<ColumnInfoDTO> columnInfoList) {
		String className = StrUtils.convertToClassName(genParam.getTableName());
		String genFileName = JAVA_DIR + "/mapper/" + className + "Mapper.java";

		ConfigParams params = buildConfigParams(genFileName, "mapper.java.ftl");
		ContentParam contentParam = initContentParam(genParam, columnInfoList, className);

		freemarkerGenerate(params, contentParam);
	}

	public static void genMapperXmlFile(GenParam genParam, List<ColumnInfoDTO> columnInfoList) {
		String className = StrUtils.convertToClassName(genParam.getTableName());
		String genFileName = RESOURCE_DIR + "/mapper/" + className + "Mapper.xml";

		ConfigParams params = buildConfigParams(genFileName, "mapper.xml.ftl");
		ContentParam contentParam = initContentParam(genParam, columnInfoList, className);

		freemarkerGenerate(params, contentParam);
	}

	public static void genModelFile(GenParam genParam, List<ColumnInfoDTO> columnInfoList) {
		String className = StrUtils.convertToClassName(genParam.getTableName());
		String genFileName = JAVA_DIR + "/" + "model" + "/" + className + ".java";

		ConfigParams params = buildConfigParams(genFileName, "model.java.ftl");
		ContentParam contentParam = initContentParam(genParam, columnInfoList, className);

		freemarkerGenerate(params, contentParam);
	}

	// 初始化填充模板内容参数
	private static ContentParam initContentParam(GenParam genParam, List<ColumnInfoDTO> columnInfoList, String className) {
		ColumnInfoDTO keyColumnInfo = columnInfoList.stream().filter(column -> StringUtils.isNotEmpty(column.getColumnKey()))
				.collect(Collectors.toList()).get(0);

		ContentParam contentParam = new ContentParam(genParam);
		contentParam.setVariableName(StrUtils.toLowerCaseFirst(className));
		contentParam.setTableName(genParam.getTableName());
		contentParam.setOriginTableName(genParam.getOriginTableName());
		contentParam.setKeyColumnInfo(keyColumnInfo);
		contentParam.setColumnInfoList(columnInfoList);

		return contentParam;
	}

	public static ConfigParams buildConfigParams(String genFileName, String templateFileName) {
		ConfigParams params = new ConfigParams();
		params.setGenerateFile(new File(genFileName));
		params.setTemplateFileName(templateFileName);
		return params;
	}

	// freemarker模板生成配置
	private static void freemarkerGenerate(ConfigParams configParams, ContentParam params) {
		// 1.创建freemarker配置
		Configuration configuration = new Configuration(VERSION_2_3_30);
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
				log.error("模板文件解析发生错误！错误信息: {}", e.getMessage());
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.error("模板文件或目录不存在！");
		}
	}

}
