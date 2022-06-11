package com.gsnotes.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsnotes.bo.Niveau;
import com.gsnotes.dao.INiveauDao;
import com.gsnotes.services.INiveauService;

@Service
@Transactional
public class NiveauServiceImpl implements INiveauService{
	@Autowired
	INiveauDao niveauDao;
	@Override
	public void AjouterNiveau(Niveau nv) {
		niveauDao.save(nv);
	}

	@Override
	public void ModierNiveau(Niveau nv) {
		niveauDao.save(nv);
	
	}

	@Override
	public List<Niveau> getAllNiveau() {
		List<Niveau> l=niveauDao.findAll();
		return l;	
		}

	@Override
	public void deleteNiveau(Long id) {
		niveauDao.deleteById(id);		
	}

	@Override
	public Niveau getNiveauById(Long id) {
		Niveau n= niveauDao.getById(id);
   		return n;
	}

	@Override
	public Niveau getFiliereByAlias(String alias) {
		Niveau n=niveauDao.getFiliereByAlias(alias);
		return n;
	}

}
