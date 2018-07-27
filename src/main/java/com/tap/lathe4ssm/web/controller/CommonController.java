package com.tap.lathe4ssm.web.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tap.lathe4ssm.web.enums.DigitalEnum;

/**
 * 公共视图控制器
 * 
 * @author
 * @since
 **/
@Controller
public class CommonController {

	/**
	 * 首页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request) {
		return "index";
	}
	
	/**
	 * 重定向到自动生成ssm代码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("codeGenerator/ssm")
	public String autoCreate(Model model, HttpServletRequest request) {
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(DigitalEnum.DB_TYPE_MYSQL.getValue(), DigitalEnum.DB_TYPE_MYSQL.getText());
		hm.put(DigitalEnum.DB_TYPE_ORACLE.getValue(), DigitalEnum.DB_TYPE_ORACLE.getText());
		
		model.addAttribute("dbTypeList", hm);
		
		return "codeGenerator/createSsm";
	}
	
}