package com.person.gen.utils.gen;

import com.person.gen.dto.ColumnInfoDTO;
import com.person.gen.query.GenParam;
import com.person.gen.utils.StrUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;

import static freemarker.template.Configuration.VERSION_2_3_30;

/**
 * @author fu.yuanming
 * @since 2020/4/4 10:22
 **/
@Slf4j
public class FreeMarkerUtils {

	private static final String SEPARATOR = File.separator;

	private FreeMarkerUtils() {

	}

	@Data
	private static class ConfigParams {

		private File generateFile;

		private String templateFileName;

	}

	public static void genServerCode(GenParam genParam, List<ColumnInfoDTO> columnInfoList) throws IOException {
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
	}

	public static void genControllerFile(GenParam genParam, List<ColumnInfoDTO> columnInfoList) throws IOException {
		String className = StrUtils.convertToClassName(genParam.getTableName());
		String genFileName = createDirIfNotExists(genParam, "controller") + SEPARATOR + className + "Controller.java";

		ConfigParams params = buildConfigParams(genFileName, "controller.java.ftl");
		ContentParam contentParam = initContentParam(genParam, columnInfoList, className);

		freemarkerGenerate(params, contentParam);
	}

	public static void genServiceFile(GenParam genParam, List<ColumnInfoDTO> columnInfoList) throws IOException {
		String className = StrUtils.convertToClassName(genParam.getTableName());
		String genFileName = createDirIfNotExists(genParam, "service") + SEPARATOR + "I" + className + "Service.java";

		ConfigParams params = buildConfigParams(genFileName, "service.java.ftl");
		ContentParam contentParam = initContentParam(genParam, columnInfoList, className);

		freemarkerGenerate(params, contentParam);
	}

	public static void genServiceImplFile(GenParam genParam, List<ColumnInfoDTO> columnInfoList) throws IOException {
		String className = StrUtils.convertToClassName(genParam.getTableName());
		String genFileName = createDirIfNotExists(genParam, "service/impl") + SEPARATOR + className + "ServiceImpl.java";

		ConfigParams params = buildConfigParams(genFileName, "serviceImpl.java.ftl");
		ContentParam contentParam = initContentParam(genParam, columnInfoList, className);

		freemarkerGenerate(params, contentParam);
	}

	public static void genPageQueryFile(GenParam genParam, List<ColumnInfoDTO> columnInfoList) throws IOException {
		String className = StrUtils.convertToClassName(genParam.getTableName());
		String genFileName = createDirIfNotExists(genParam, "query") + SEPARATOR + className + "PageQuery.java";

		ConfigParams params = buildConfigParams(genFileName, "pageQuery.java.ftl");
		ContentParam contentParam = initContentParam(genParam, columnInfoList, className);

		freemarkerGenerate(params, contentParam);
	}

	public static void genMapperFile(GenParam genParam, List<ColumnInfoDTO> columnInfoList) throws IOException {
		String className = StrUtils.convertToClassName(genParam.getTableName());
		String genFileName = createDirIfNotExists(genParam, "mapper") + SEPARATOR + className + "Mapper.java";

		ConfigParams params = buildConfigParams(genFileName, "mapper.java.ftl");
		ContentParam contentParam = initContentParam(genParam, columnInfoList, className);

		freemarkerGenerate(params, contentParam);
	}

	public static void genMapperXmlFile(GenParam genParam, List<ColumnInfoDTO> columnInfoList) throws IOException {
		String className = StrUtils.convertToClassName(genParam.getTableName());
		String path = genParam.getProjectPath() + SEPARATOR + genParam.getSourcePath() + SEPARATOR + "mapper";
		String genFileName = path + SEPARATOR + className + "Mapper.xml";
		File dir = new File(path);
		if (!dir.exists()) {
			boolean mkdirs = dir.mkdirs();
			if (mkdirs) {
				log.info("文件夹{}创建成功", dir.getName());
			}
		}

		ConfigParams params = buildConfigParams(genFileName, "mapper.xml.ftl");
		ContentParam contentParam = initContentParam(genParam, columnInfoList, className);

		freemarkerGenerate(params, contentParam);
	}

	public static void genModelFile(GenParam genParam, List<ColumnInfoDTO> columnInfoList) throws IOException {
		String className = StrUtils.convertToClassName(genParam.getTableName());
		String genFileName = createDirIfNotExists(genParam, "model") + SEPARATOR + className + ".java";

		ConfigParams params = buildConfigParams(genFileName, "model.java.ftl");
		ContentParam contentParam = initContentParam(genParam, columnInfoList, className);

		freemarkerGenerate(params, contentParam);
	}

	private static String createDirIfNotExists(GenParam genParam, String dirName) {
		String path = genParam.getProjectPath() + SEPARATOR + genParam.getJavaPath() + SEPARATOR  + dirName;
		File dir = new File(path);
		if (!dir.exists()) {
			boolean mkdirs = dir.mkdirs();
			if (mkdirs) {
				log.info("文件夹{}创建成功", dir.getAbsolutePath() + dir.getName());
			}
		}
		return path;
	}


	/**
	 * 初始化填充模板内容参数
	 *
	 * @param genParam       创参数
	 * @param columnInfoList 列信息列表
	 * @param className      类名
	 * @return {@link ContentParam}
	 */
	private static ContentParam initContentParam(GenParam genParam, List<ColumnInfoDTO> columnInfoList, String className) {
		ColumnInfoDTO keyColumnInfo = columnInfoList.stream().filter(column -> StringUtils.isNotEmpty(column.getColumnKey()))
				.collect(Collectors.toList()).get(0);

		ContentParam contentParam = new ContentParam(genParam);
		contentParam.setVariableName(StrUtils.toLowerCaseFirst(className));
		contentParam.setTableName(genParam.getTableName());
		contentParam.setOriginTableName(genParam.getOriginTableName());
		contentParam.setKeyColumnInfo(keyColumnInfo);
		contentParam.setColumnInfoList(columnInfoList);
		for (ColumnInfoDTO columnInfo : columnInfoList) {
			if (columnInfo.getJavaType().contains("Date")) {
				contentParam.setDateJavaType("Date");
			}
			if (columnInfo.getJavaType().contains("BigDecimal")) {
				contentParam.setBigDecimalJavaType("BigDecimal");
			}
		}

		return contentParam;
	}

	public static ConfigParams buildConfigParams(String genFileName, String templateFileName) {
		ConfigParams params = new ConfigParams();
		params.setGenerateFile(new File(genFileName));
		params.setTemplateFileName(templateFileName);
		return params;
	}


	/**
	 * freemarker生成
	 *
	 * @param configParams 配置参数
	 * @param params       参数个数
	 */
	private static void freemarkerGenerate(ConfigParams configParams, ContentParam params) throws IOException {
		// 1.创建freemarker配置
		Configuration configuration = new Configuration(VERSION_2_3_30);
		// 2.设置字符集
		configuration.setDefaultEncoding("utf-8");
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
	}

}
