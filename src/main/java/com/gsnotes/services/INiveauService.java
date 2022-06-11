package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Niveau;

public interface INiveauService {
	public void AjouterNiveau(Niveau nv);

	public void ModierNiveau(Niveau nv);

	public List<Niveau> getAllNiveau();

	public void deleteNiveau(Long id);

	public Niveau getNiveauById(Long id);
	public Niveau getFiliereByAlias(String alias);


}
