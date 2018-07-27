package ${packageName}.web.service;

import java.util.List;

import ${packageName}.core.generic.GenericService;
import ${packageName}.web.model.${ControllerName};

/**
 * Service inferface
 * 
 * @author 
 * @since 
 **/
public interface ${ControllerName}Service extends GenericService<${ControllerName}, ${ keyType }> {
       
	public List<${ControllerName}> selectListByPage(Integer pageNo, Integer pageSize, ${ControllerName} model);
	
	public Long getListCount( ${ControllerName} model);

}