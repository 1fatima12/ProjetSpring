package com.gsnotes.services.impl;

import java.util.List;

import org.aspectj.weaver.NewFieldTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsnotes.bo.Module;
import com.gsnotes.dao.IModuleDao;
import com.gsnotes.services.IModuleService;

@Service
@Transactional
public class ModuleServiceImpl implements IModuleService{
	@Autowired
	private IModuleDao moduleDao;

	public Module AjouterModule(Module module) {
		moduleDao.save(module);	
           return module;
	}

	public void ModierModule(Module module) {
		moduleDao.save(module);
	}


	public List<Module> getAllModule() {
		
		return moduleDao.findAll();
	}


	public void deleteModule(Long id) {
		moduleDao.deleteById(id);
	}

	
	public Module getModuleById(Long id) {
		return moduleDao.getById(id);
	}

	public Module getModuleByCode(String code) {
		// TODO Auto-generated method stub
		return moduleDao.getModuleByCode(code);
	}
	
	

}
