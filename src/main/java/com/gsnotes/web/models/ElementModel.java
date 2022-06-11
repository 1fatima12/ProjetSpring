package com.gsnotes.web.models;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.gsnotes.bo.Enseignant;
import com.gsnotes.bo.Module;

public class ElementModel {

	private Long idMatiere;
	@NotBlank(message = "This field is required")

	private String nom;
	@NotBlank(message = "This field is required")

	private String code;

	private double currentCoefficient;

	//@ManyToOne
	//@JoinColumn(name="idModule")
	private Module module;
	//@ManyToOne
	private Enseignant enseignant;

	public Long getIdMatiere() {
		return idMatiere;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public double getCurrentCoefficient() {
		return currentCoefficient;
	}

	public void setCurrentCoefficient(double currentCoefficient) {
		this.currentCoefficient = currentCoefficient;
	}
	
	

}
