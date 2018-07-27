package com.tap.lathe4ssm.core.generator;

import javax.servlet.http.HttpServletRequest;

/**
 * 封装与生成的目标文件相关的信息
 * 
 * @author York Wu
 *
 */
public class GeneratorConfig {
	
	public GeneratorConfig() {
		targetPackage = "com.tap";
		targetViewPath = "e:\\temp\\";
		targetControllerPath = "e:\\temp\\";
		targetServicePath = "e:\\temp\\";
	}

	// db type
	private int dbType;
	
	// schema
	private String tableSchema;
	
	// 表名
	private String tableName;
	
	// 主键
	private String keyName;

	// 主键类型
	private String keyType;
	
	// 模块名
	private String moduleName;
	
	// 上级模块名
	private String parentModule;

	// 生成类的package
	private String targetPackage;
	
	// 生成view文件的目标路径
	private String targetViewPath;
	
	// 生成controller文件的目标路径
	private String targetControllerPath;
	
	// 生成service文件的目标路径
	private String targetServicePath;

	private HttpServletRequest request;
	
	public int getDbType() {
		return dbType;
	}

	public void setDbType(int dbType) {
		this.dbType = dbType;
	}

	public String getTableSchema() {
		return tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getParentModule() {
		return parentModule;
	}

	public void setParentModule(String parentModule) {
		this.parentModule = parentModule;
	}

	public String getTargetPackage() {
		return targetPackage;
	}

	public void setTargetPackage(String targetPackage) {
		this.targetPackage = targetPackage;
	}

	public String getTargetViewPath() {
		return targetViewPath;
	}

	public void setTargetViewPath(String targetViewPath) {
		this.targetViewPath = targetViewPath;
	}

	public String getTargetControllerPath() {
		return targetControllerPath;
	}

	public void setTargetControllerPath(String targetControllerPath) {
		this.targetControllerPath = targetControllerPath;
	}

	public String getTargetServicePath() {
		return targetServicePath;
	}

	public void setTargetServicePath(String targetServicePath) {
		this.targetServicePath = targetServicePath;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getKeyType() {
		return keyType;
	}

	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
