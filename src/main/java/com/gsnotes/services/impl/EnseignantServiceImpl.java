package com.gsnotes.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsnotes.bo.Enseignant;
import com.gsnotes.dao.IEnseignantDao;
import com.gsnotes.services.IEnseignantService;

@Service
@Transactional
public class EnseignantServiceImpl implements IEnseignantService{
	@Autowired
	IEnseignantDao Service;
	@Override
	public void AjouterEnseignant(Enseignant enseignant) {
       	Service.save(enseignant);
	}

	@Override
	public void ModifierEnseignent(Enseignant enseignant) {
		Service.save(enseignant); 		
	}

	@Override
	public List<Enseignant> getAllEnseignant() {
		List<Enseignant> l=Service.findAll();
		return l;
	}

	@Override
	public void deleteEnseignant(Long id) {
           Service.deleteById(id);		
	}

	@Override
	public Enseignant getEnseignantById(Long id) {
		Enseignant e=Service.getById(id);
		return e;
	}

}
