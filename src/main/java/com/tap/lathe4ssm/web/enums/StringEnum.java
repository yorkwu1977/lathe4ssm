package com.tap.lathe4ssm.web.enums;

import com.tap.lathe4ssm.core.generic.GenericEnum;

public enum StringEnum implements GenericEnum<String, String> {

	APPLICATION_WEB_BASEPATH("base_path", "web应用根路径"),
	APPLICATION_WEB_PREFIX("/rest", "url前缀"),
	SESSION_ATTRIBUTE_USER("user", "用户对象"),
	FLAG_AJAX_SESSION_TIMEOUT("ajax_session_timeout", "异步请求时session超时的标识"),
	FLAG_AJAX_ERROR("ajax_error", "异步请求时发生异常的标识"),
	COMPANY_STATUS_ON("ON", "启用"),
	COMPANY_STATUS_OFF("OFF", "禁用");
	
	private final String value;
	private final String text;

	private StringEnum(String value, String text) {
		this.value = value;
		this.text = text;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getText() {
		return text;
	}

}
