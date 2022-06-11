package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Enseignant;


public interface IEnseignantService {
	public void AjouterEnseignant(Enseignant enseignant);

	public void ModifierEnseignent(Enseignant enseignant);

	public List<Enseignant> getAllEnseignant();

	public void deleteEnseignant(Long id);

	public Enseignant getEnseignantById(Long id);
	

}
