package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Module;

public interface IModuleService {
	public Module AjouterModule(Module module);

	public void ModierModule(Module module);

	public List<Module> getAllModule();

	public void deleteModule(Long id);

	public Module getModuleById(Long id);
	
	public Module getModuleByCode(String code);

	
	//public Module getPersonByCin(String cin);

}
