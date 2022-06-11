package com.gsnotes.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsnotes.bo.Filiere;
import com.gsnotes.dao.IFiliereDao;
import com.gsnotes.services.IFiliereService;

@Service
@Transactional
public class FiliereServiceImpl implements IFiliereService{
	@Autowired
	IFiliereDao filieredao;

	@Override
	public void AjouterFiliere(Filiere filiere) {
          		filieredao.save(filiere);
	}

	@Override
	public void ModierFiliere(Filiere filiere) {
          filieredao.save(filiere);		
	}

	@Override
	public List<Filiere> getAllFiliere() {
		List<Filiere> l=filieredao.findAll();
		return l;
	}

	@Override
	public void deleteFiliere(Long id) {
          filieredao.deleteById(id);		
	}

	@Override
	public Filiere getFiliereById(Long id) {
		Filiere f= filieredao.getById(id);
   		return f;
	}

	@Override
	public Filiere getFiliereByCodeFiliere(String codeFiliere) {
Filiere f= filieredao.getFiliereByCodeFiliere(codeFiliere);
return f;
	}


}
