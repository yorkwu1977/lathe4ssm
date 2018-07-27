package com.tap.lathe4ssm.web.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tap.lathe4ssm.core.generic.GenericDao;
import com.tap.lathe4ssm.web.model.TableInfo;

/**
 * TableInfo接口,用于查询表结构，自动生成页面
 * 
 * @author 
 * @since 
 **/
public interface TableInfoMapper extends GenericDao<TableInfo, Long> {
   
    List<HashMap<String, String>> selectTableColumnByMySql(@Param("tableName") String tableName, @Param("tableSchema") String tableSchema);

    List<HashMap<String, String>> selectTableColumnByOracle(@Param("tableName") String tableName);

    List<HashMap<String, String>> selectTableRowBy(@Param("tableName") String tableName, @Param("condition") String condition);

    TableInfo selectTableKeyForMySql(@Param("tableName") String tableName, @Param("tableSchema") String tableSchema);

    TableInfo selectTableKeyForOracle(@Param("tableName") String tableName);
  
}