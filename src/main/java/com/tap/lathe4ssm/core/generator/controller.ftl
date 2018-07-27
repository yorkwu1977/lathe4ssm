package ${packageName}.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ${packageName}.core.feature.orm.mybatis.Page;
import ${packageName}.web.model.*;
import ${packageName}.web.service.*;

/**
 * Controller class
 * 
 * @author
 * @since
 **/
@Controller
@RequestMapping(value = "${parentModule}${moduleName}/")
public class ${ControllerName}Controller {

    @Resource
    private ${ControllerName}Service ${moduleName}Service;
    
    
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request) {

		return "redirect:list";
	}
	
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Model model, HttpServletRequest request) {

        return "${parentModule}${moduleName}/create";
    }
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request) {
	
		int pageNo = 1;
    	int pageSize = 5;
    	if (request.getParameter("pageNo") != null) {
    		pageNo = Integer.parseInt(request.getParameter("pageNo"));
    	}
    	if (request.getParameter("pageSize") != null) {
    		pageSize = Integer.parseInt(request.getParameter("pageSize"));
    	}
	
    	Page<${ControllerName}> page = new Page<${ControllerName}>(pageNo, pageSize);
		${ControllerName} ${moduleName} = new ${ControllerName}();
    	int totalCount = ${moduleName}Service.getListCount(${moduleName}).intValue();
    	page.setTotalCount(totalCount);
  
    	List<${ControllerName}> list${ControllerName} = ${moduleName}Service.selectListByPage(page.getOffset(), page.getLimit(), ${moduleName});
    	page.setResult(list${ControllerName});

    	model.addAttribute("page", page);
    	
        return "${parentModule}${moduleName}/list";
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@Valid ${ keyType } ${ keyName }, Model model, HttpServletRequest request) {
    	${ControllerName} ${moduleName} = ${moduleName}Service.selectById(${ keyName });
    	model.addAttribute("${moduleName}", ${moduleName});
    	
        return "${parentModule}${moduleName}/edit";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@Valid ${ keyType } ${ keyName }, Model model, HttpServletRequest request) {
    	${ControllerName} ${moduleName} = ${moduleName}Service.selectById(${ keyName });
    	model.addAttribute("${moduleName}", ${moduleName});
    	
        return "${parentModule}${moduleName}/delete";
    }
    
    @RequestMapping(value = "delOk", method = RequestMethod.POST)
    public String delOk(@Valid ${ keyType } ${ keyName }, Model model, HttpServletRequest request) {
    	int i = ${moduleName}Service.delete(${ keyName });
    	model.addAttribute("result", i);
    	
        return "redirect:list";
    }
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@Valid ${ControllerName} ${moduleName}, Model model, HttpServletRequest request) {
    	
    	// 根据实际需要修改这个判断逻辑
		if (${moduleName}.get${ keyName?cap_first }().toString() != "") {
			${moduleName}Service.update(${moduleName});
		} else {
			// 如果是uuid主键， 通过UUIDGenerator.getUUID32()生成
			${moduleName}Service.insert(${moduleName});
		}
		
        return "redirect:list";
    }
}
