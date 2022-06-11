package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Filiere;

public interface IFiliereService {
	public void AjouterFiliere(Filiere filiere);

	public void ModierFiliere(Filiere filiere);

	public List<Filiere> getAllFiliere();

	public void deleteFiliere(Long id);

	public Filiere getFiliereById(Long id);
	public Filiere getFiliereByCodeFiliere(String codeFiliere);
}
