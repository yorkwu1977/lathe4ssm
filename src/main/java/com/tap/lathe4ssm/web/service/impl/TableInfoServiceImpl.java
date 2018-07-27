package com.tap.lathe4ssm.web.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tap.lathe4ssm.core.generic.GenericDao;
import com.tap.lathe4ssm.core.generic.GenericServiceImpl;
import com.tap.lathe4ssm.web.dao.TableInfoMapper;
import com.tap.lathe4ssm.web.model.TableInfo;
import com.tap.lathe4ssm.web.service.TableInfoService;;

/**
 * 用户Service实现类
 *
 * @author 
 * @since 
 */
@Service
public class TableInfoServiceImpl extends GenericServiceImpl<TableInfo, Long> implements TableInfoService {

    @Resource
    private TableInfoMapper tableInfoMapper;

    @Override
    public GenericDao<TableInfo, Long> getDao() {
        return tableInfoMapper;
    }
    
    @Override
    public List<HashMap<String, String>> selectTableColumnByMySql(String tableName, String tableSchema) {    
        List<HashMap<String, String>> list = tableInfoMapper.selectTableColumnByMySql(tableName, tableSchema);
        return list;
    }

    @Override
    public List<HashMap<String, String>> selectTableColumnByOracle(String tableName) {    
        List<HashMap<String, String>> list = tableInfoMapper.selectTableColumnByOracle(tableName);
        return list;
    }
    
    @Override
    public TableInfo selectTableKeyForMySql(String tableName, String tableSchema) {
    	TableInfo tabInfo = tableInfoMapper.selectTableKeyForMySql(tableName, tableSchema);
         return tabInfo;
    }

    @Override
    public TableInfo selectTableKeyForOracle(String tableName) {
    	TableInfo tabInfo = tableInfoMapper.selectTableKeyForOracle(tableName);
         return tabInfo;
    }
    
    @Override
    public List<HashMap<String, String>> selectTableRowBy(String tableName, String condition) {
    	List<HashMap<String, String>> list = tableInfoMapper.selectTableRowBy(tableName, condition);
        return list;
    }
    
}
