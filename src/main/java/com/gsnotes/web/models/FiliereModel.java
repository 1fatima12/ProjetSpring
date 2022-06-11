package com.gsnotes.web.models;

import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.gsnotes.bo.Enseignant;
import com.gsnotes.bo.Niveau;

public class FiliereModel {
	private Long idFiliere;
	@NotBlank(message = "This field is required")

	private String titreFiliere;
	@NotBlank(message = "This field is required")

	private String codeFiliere;

	private int anneeaccreditation;

	private int anneeFinaccreditation;

	private Set<Niveau> niveaux;
//	@NotBlank(message = "This field is required")
	@OneToOne
	@JoinColumn(name="Cordinateur")
    private Enseignant enseignant;
	public FiliereModel() {
		
	}
	@Override
	public String toString() {
		return "FiliereModule [idFiliere=" + idFiliere + ", titreFiliere=" + titreFiliere + ", codeFiliere="
				+ codeFiliere + ", anneeaccreditation=" + anneeaccreditation + ", anneeFinaccreditation="
				+ anneeFinaccreditation + ", niveaux=" + niveaux + ", enseignant=" + enseignant + "]";
	}
	public Long getIdFiliere() {
		return idFiliere;
	}
	public void setIdFiliere(Long idFiliere) {
		this.idFiliere = idFiliere;
	}
	public String getTitreFiliere() {
		return titreFiliere;
	}
	public void setTitreFiliere(String titreFiliere) {
		this.titreFiliere = titreFiliere;
	}
	public String getCodeFiliere() {
		return codeFiliere;
	}
	public void setCodeFiliere(String codeFiliere) {
		this.codeFiliere = codeFiliere;
	}
	public int getAnneeaccreditation() {
		return anneeaccreditation;
	}
	public void setAnneeaccreditation(int anneeaccreditation) {
		this.anneeaccreditation = anneeaccreditation;
	}
	public int getAnneeFinaccreditation() {
		return anneeFinaccreditation;
	}
	public void setAnneeFinaccreditation(int anneeFinaccreditation) {
		this.anneeFinaccreditation = anneeFinaccreditation;
	}
	public Set<Niveau> getNiveaux() {
		return niveaux;
	}
	public void setNiveaux(Set<Niveau> niveaux) {
		this.niveaux = niveaux;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
}
