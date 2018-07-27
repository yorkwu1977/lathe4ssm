package ${packageName}.web.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ${packageName}.core.generic.GenericDao;
import ${packageName}.core.generic.GenericServiceImpl;
import ${packageName}.web.dao.${ControllerName}Mapper;
import ${packageName}.web.model.${ControllerName};
import ${packageName}.web.service.${ControllerName}Service;

/**
 * Service implement class
 *
 * @author 
 * @since 
 */
@Service
public class ${ControllerName}ServiceImpl extends GenericServiceImpl<${ControllerName}, ${ keyType }> implements ${ControllerName}Service {

    @Resource
    private ${ControllerName}Mapper ${moduleName}Mapper;

    @Override
    public GenericDao<${ControllerName}, ${ keyType }> getDao() {
        return ${moduleName}Mapper;
    }
 
	public List<${ControllerName}> selectListByPage(Integer pageNo, Integer pageSize,  ${ControllerName} model) {
		return ${moduleName}Mapper.selectListByPage(pageNo, pageSize, model);
	}
	
	public Long getListCount( ${ControllerName} model) {
		return ${moduleName}Mapper.getListCount(model);
	}

}
