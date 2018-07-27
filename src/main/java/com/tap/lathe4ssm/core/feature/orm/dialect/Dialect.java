package com.tap.lathe4ssm.core.feature.orm.dialect;

/**
 * 数据库查询语言抽象类
 * 
 * @author 
 * @since 
 **/
public abstract class Dialect {

    /**
     * 得到分页sql
     * 
     * @param sql
     * @param offset
     * @param limit
     * @return
     */
    public abstract String getLimitString(String sql, int offset, int limit);

    /**
     * 得到总数量 sql
     * 
     * @param sql
     * @return
     */
    public abstract String getCountString(String sql);

}
