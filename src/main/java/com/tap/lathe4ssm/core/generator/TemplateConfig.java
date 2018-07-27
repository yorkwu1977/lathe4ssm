package com.tap.lathe4ssm.core.generator;

/**
 * 封装模板文件相关的信息
 * 
 * @author York Wu
 *
 */
public class TemplateConfig {

	public static final String TEMPLATE_WEB_PATH = "\\WEB-INF\\classes\\com\\tap\\lathe4ssm\\core\\generator\\";

	public TemplateConfig() {
		templateName_list = "list.ftl";
		templateName_create = "create.ftl";
		templateName_edit = "edit.ftl";
		templateName_delete ="delete.ftl";
		templateControllerName = "controller.ftl";
		templateServiceName = "service.ftl";
		templateServiceImplName = "serviceImpl.ftl";
	}
	
	private String tempateViewPath;
	
	private String templateName_list;
	
	private String templateName_create;
	
	private String templateName_edit;
	
	private String templateName_delete;
	
	private String templateControllerPath;
	
	private String templateControllerName;
	
	private String templateServicePath;
	
	private String templateServiceName;

	private String templateServiceImplName;
	
	public String getTempateViewPath() {
		return tempateViewPath;
	}

	public void setTempateViewPath(String tempateViewPath) {
		this.tempateViewPath = tempateViewPath;
	}

	public String getTemplateName_list() {
		return templateName_list;
	}

	public void setTemplateName_list(String templateName_list) {
		this.templateName_list = templateName_list;
	}

	public String getTemplateName_create() {
		return templateName_create;
	}

	public void setTemplateName_create(String templateName_create) {
		this.templateName_create = templateName_create;
	}

	public String getTemplateName_edit() {
		return templateName_edit;
	}

	public void setTemplateName_edit(String templateName_edit) {
		this.templateName_edit = templateName_edit;
	}

	public String getTemplateName_delete() {
		return templateName_delete;
	}

	public void setTemplateName_delete(String templateName_delete) {
		this.templateName_delete = templateName_delete;
	}

	public String getTemplateControllerPath() {
		return templateControllerPath;
	}

	public void setTemplateControllerPath(String templateControllerPath) {
		this.templateControllerPath = templateControllerPath;
	}

	public String getTemplateControllerName() {
		return templateControllerName;
	}

	public void setTemplateControllerName(String templateControllerName) {
		this.templateControllerName = templateControllerName;
	}

	public String getTemplateServicePath() {
		return templateServicePath;
	}

	public void setTemplateServicePath(String templateServicePath) {
		this.templateServicePath = templateServicePath;
	}

	public String getTemplateServiceName() {
		return templateServiceName;
	}

	public void setTemplateServiceName(String templateServiceName) {
		this.templateServiceName = templateServiceName;
	}

	public String getTemplateServiceImplName() {
		return templateServiceImplName;
	}

	public void setTemplateServiceImplName(String templateServiceImplName) {
		this.templateServiceImplName = templateServiceImplName;
	}

}
