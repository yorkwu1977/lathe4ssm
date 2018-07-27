package com.tap.lathe4ssm.web.service;

import java.util.HashMap;
import java.util.List;

import com.tap.lathe4ssm.core.generic.GenericService;
import com.tap.lathe4ssm.web.model.TableInfo;;

/**
 * 自动生成View和Controller，表结构信息 接口
 * 
 * @author 
 * @since 
 **/
public interface TableInfoService extends GenericService<TableInfo, Long> {

    /**
     * 查询表信息
     * 
     * @param username
     * @return
     */
    List<HashMap<String, String>> selectTableColumnByMySql(String tableName, String tableSchema);

    /**
     * 查询表信息
     * 
     * @param username
     * @return
     */
    List<HashMap<String, String>> selectTableColumnByOracle(String tableName);

    /**
     * 查询表的主键字段
     * 
     * @param username
     * @return
     */
    TableInfo selectTableKeyForMySql(String tableName, String tableSchema);

    /**
     * 查询表的主键字段
     * 
     * @param username
     * @return
     */
    TableInfo selectTableKeyForOracle(String tableName);
    
    /**
     * 获取表数据
     * @param tableName
     * @param condition
     * @return
     */
    List<HashMap<String, String>> selectTableRowBy(String tableName, String condition);

}
