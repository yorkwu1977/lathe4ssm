package com.tap.lathe4ssm.core.entity;

/**
 * UserException : 用户自定义异常
 *
 * @author 
 * @since 
 */
public class UserException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 异常发生时间
     */
    private long date = System.currentTimeMillis();

    public long getDate() {
        return date;
    }
}
