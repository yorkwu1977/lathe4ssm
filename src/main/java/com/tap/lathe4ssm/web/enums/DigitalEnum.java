package com.tap.lathe4ssm.web.enums;

import com.tap.lathe4ssm.core.generic.GenericEnum;

public enum DigitalEnum implements GenericEnum<Integer, String> {

	DB_TYPE_MYSQL(1,"mysql数据库"),
	DB_TYPE_ORACLE(2,"oracle数据库");

	private final Integer value;
	private final String text;

	private DigitalEnum(Integer value, String text) {
		this.value = value;
		this.text = text;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public String getText() {
		return text;
	}

}
