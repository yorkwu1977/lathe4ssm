package com.tap.lathe4ssm.core.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * 生成View，Controller，Service文件。
 * 
 * @author York Wu
 *
 */
public class CreateSsm {

	private GeneratorConfig m_gerCfg;
	
	private TemplateConfig m_tmpCfg;

	private HttpServletRequest m_request;

	public CreateSsm(HttpServletRequest request, GeneratorConfig gerCfg, TemplateConfig tmpCfg) {
		m_gerCfg = gerCfg != null ? gerCfg : new GeneratorConfig();
		m_tmpCfg = tmpCfg != null ? tmpCfg : new TemplateConfig();
		
		m_request = request;

		m_gerCfg.setTargetViewPath(takeCarePath(m_gerCfg.getTargetViewPath()));
		m_gerCfg.setTargetControllerPath(takeCarePath(m_gerCfg.getTargetControllerPath()));
		m_gerCfg.setTargetServicePath(takeCarePath(m_gerCfg.getTargetServicePath()));
		
		m_tmpCfg.setTempateViewPath(m_request.getSession().getServletContext().getRealPath("/") + TemplateConfig.TEMPLATE_WEB_PATH);
		m_tmpCfg.setTemplateControllerPath(m_tmpCfg.getTempateViewPath());
		m_tmpCfg.setTemplateServicePath(m_tmpCfg.getTempateViewPath());
		
		System.out.println("1 View template path：" + m_tmpCfg.getTempateViewPath());
		System.out.println("1 View target path：" + gerCfg.getTargetViewPath());
		
		System.out.println("2 controller template path：" + m_tmpCfg.getTemplateControllerPath());
		System.out.println("2 controller target path：" + gerCfg.getTargetControllerPath());
		
		System.out.println("3 service template path：" + m_tmpCfg.getTemplateServicePath());
		System.out.println("3 service target path：" + gerCfg.getTargetServicePath());
	}

	/**
	 * 
	 * @param listColumn
	 * @return
	 */
	public String CreatAll(List<HashMap<String, String>> listColumn) {
		Map<String, Object> root = new HashMap<String, Object>();

		String msg = "已经生成代码！<br />View文件在" + m_gerCfg.getTargetViewPath() + m_gerCfg.getModuleName() + "目录下; <br />" + "Controller文件在"
				+ m_gerCfg.getTargetControllerPath() + "目录下; <br />" + "Service文件在" + m_gerCfg.getTargetServicePath() + "目录下。";

		try {

			// 递归创建子目录
			creatDirs(m_gerCfg.getTargetViewPath(), m_gerCfg.getModuleName());
			creatDirs(m_gerCfg.getTargetServicePath(), "impl");

			// ----- 生成View
			root.put("columns", listColumn);
			root.put("moduleName", m_gerCfg.getModuleName());
			root.put("parentModule", (m_gerCfg.getParentModule() != null && m_gerCfg.getParentModule() != "") ? m_gerCfg.getParentModule() + "/" : "");
			root.put("tableName", m_gerCfg.getTableName());
			root.put("keyName", m_gerCfg.getKeyName());
			root.put("keyType", m_gerCfg.getKeyType());

			String strTempTarget = m_gerCfg.getTargetViewPath() + m_gerCfg.getModuleName(); 
			String strTempViewPath = m_tmpCfg.getTempateViewPath();
			
			crateFile(root, strTempViewPath, m_tmpCfg.getTemplateName_list(), strTempTarget + "\\list.jsp");	
			crateFile(root, strTempViewPath, m_tmpCfg.getTemplateName_create(), strTempTarget + "\\create.jsp");
			crateFile(root, strTempViewPath, m_tmpCfg.getTemplateName_edit(), strTempTarget + "\\edit.jsp");
			crateFile(root, strTempViewPath, m_tmpCfg.getTemplateName_delete(), strTempTarget + "\\delete.jsp");

			// ----- 生成Controller
			root.put("ControllerName", upcaseFirstLetter(m_gerCfg.getModuleName()));
			root.put("packageName", m_gerCfg.getTargetPackage());
			
			String targetControllerName = m_gerCfg.getTargetControllerPath() + upcaseFirstLetter(m_gerCfg.getModuleName()) + "Controller.java";
			crateFile(root, m_tmpCfg.getTemplateControllerPath(), m_tmpCfg.getTemplateControllerName(), targetControllerName);

			// ----- 生成Service
			String targetServiceName = m_gerCfg.getTargetServicePath() + upcaseFirstLetter(m_gerCfg.getModuleName()) + "Service.java";
			crateFile(root, m_tmpCfg.getTemplateServicePath(), m_tmpCfg.getTemplateServiceName(), targetServiceName);

			// ----- 生成ServiceImpl
			String targetServiceImplName = m_gerCfg.getTargetServicePath() + "impl\\" + upcaseFirstLetter(m_gerCfg.getModuleName())
					+ "ServiceImpl.java";
			crateFile(root, m_tmpCfg.getTemplateServicePath(), m_tmpCfg.getTemplateServiceImplName(), targetServiceImplName);

		} catch (Exception e) {
			msg = e.getMessage();
		}

		return msg;
	}

	protected void crateFile(Map<String, Object> data, String tempateFilePath, String templateFileName,
			String targetFilePath) {
		Configuration freemarkerCfg = new Configuration();
		// 加载模版
		Writer out = null;
		try {
			// 设置要解析的模板所在的目录，并加载模板文件
			freemarkerCfg.setDirectoryForTemplateLoading(new File(tempateFilePath));
			// 设置包装器，并将对象包装为数据模型
			freemarkerCfg.setObjectWrapper(new DefaultObjectWrapper());
			// 指定模版路径
			Template template = freemarkerCfg.getTemplate(templateFileName, "UTF-8");

			FileOutputStream fos = new FileOutputStream(targetFilePath);
			out = new OutputStreamWriter(fos, "UTF-8");
			// 合并数据模型与模板
			template.process(data, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.flush();
				out.close();
				System.out.println("已完成-自动生成页面：" + targetFilePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 创建多级目录
	 *
	 * @param aParentDir
	 * @param aSubDir
	 * @return boolean 是否成功
	 */
	public static boolean creatDirs(String aParentDir, String aSubDir) {
		File aFile = new File(aParentDir);
		if (aFile.exists()) {
			File aSubFile = new File(aParentDir + aSubDir);
			if (!aSubFile.exists()) {
				return aSubFile.mkdirs();
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * 首字母大写
	 * 
	 * @param str
	 * @return
	 */
	public static String upcaseFirstLetter(String str) {
		String s1 = "";
		String s2 = "";
		if (!str.isEmpty()) {
			s1 = str.substring(0, 1);
			s2 = str.substring(1);
		}
		return s1.toUpperCase() + s2;
	}

	/**
	 * 如果路径最后没有斜杠，加上。
	 * 
	 * @param str
	 * @return
	 */
	public static String takeCarePath(String str) {
		String temp = str.substring(str.length() - 1);

		System.out.println("takeCarePath 1: " + temp);
		if (temp != "\\\\") {
			if (temp == "\\") {
				temp = str + "\\";
			} else {
				temp = str + "\\\\";
			}
		}
		System.out.println("takeCarePath 2: " + temp);
		return temp;
	}

}
