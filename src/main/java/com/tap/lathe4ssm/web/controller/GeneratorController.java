package com.tap.lathe4ssm.web.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tap.lathe4ssm.core.generator.CreateSsm;
import com.tap.lathe4ssm.core.generator.GeneratorConfig;
import com.tap.lathe4ssm.core.generator.TemplateConfig;
import com.tap.lathe4ssm.web.enums.DigitalEnum;
import com.tap.lathe4ssm.web.model.TableInfo;
import com.tap.lathe4ssm.web.service.TableInfoService;

/**
 * 自动生成Controller和View的控制器
 * 
 * @author
 * @since
 **/
@Controller
@RequestMapping("/codeGenerator")
public class GeneratorController {

	@Resource
	private TableInfoService tableInfoService;

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/doCreate")
	public String createSsm(GeneratorConfig gerCfg, Model model, HttpServletRequest request) {

		System.out.println(gerCfg.getTableSchema() + ":" + gerCfg.getTableName() + ":" + gerCfg.getModuleName());

		System.out.println(gerCfg.getDbType());

		String msg = "";
		int dbType = gerCfg.getDbType();

		if (gerCfg != null && gerCfg.getTableSchema() != null && gerCfg.getTableName() != null) {

			List<HashMap<String, String>> listTableInfo;
			TableInfo tabInfo;

			try {
				if (dbType == DigitalEnum.DB_TYPE_MYSQL.getValue()) {
					// 获取数据表的列信息
					listTableInfo = tableInfoService.selectTableColumnByMySql(gerCfg.getTableName(),
							gerCfg.getTableSchema());
					// 获取数据表的主键名
					tabInfo = tableInfoService.selectTableKeyForMySql(gerCfg.getTableName(), gerCfg.getTableSchema());
				} else if (dbType == DigitalEnum.DB_TYPE_ORACLE.getValue()) {
					// 获取数据表的列信息
					listTableInfo = tableInfoService.selectTableColumnByOracle(gerCfg.getTableName());
					// 获取数据表的主键名
					tabInfo = tableInfoService.selectTableKeyForOracle(gerCfg.getTableName());
				} else {
					listTableInfo = null;
					tabInfo = null;
				}

				gerCfg.setKeyName(tabInfo.getColumnName());

				System.out.println(">>>>>> createSsm():" + listTableInfo.size());
				System.out.println("key dataType:" + tabInfo.getDataType());

				// 判断主键字段类型
				if (tabInfo.getDataType().toLowerCase().contains("varchar")) {
					gerCfg.setKeyType("String");
				} else {
					gerCfg.setKeyType("Long");
				}

				TemplateConfig tmpCfg = new TemplateConfig();

				msg = new CreateSsm(request, gerCfg, tmpCfg).CreatAll(listTableInfo);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			msg = "信息不完善，无法生成代码。请完善信息后重试。";
		}

		model.addAttribute("msg", msg);

		return "codeGenerator/result";
	}

}