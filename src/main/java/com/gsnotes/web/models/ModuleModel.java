package com.gsnotes.web.models;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.gsnotes.bo.Element;
import com.gsnotes.bo.Niveau;

public class ModuleModel {
	private Long idModule;
	@NotBlank(message = "This field is required")

	private String titre;
	@NotBlank(message = "This field is required")

	private String code;
	private List<Element> elements;

	private Niveau niveau;
	public ModuleModel() {
		
	}
	@Override
	public String toString() {
		return "ModuleModel [idModule=" + idModule + ", titre=" + titre + ", code=" + code + ", elements=" + elements
				+ ", niveau=" + niveau + "]";
	}
	public Long getIdModule() {
		return idModule;
	}
	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Element> getElements() {
		return elements;
	}
	public void setElements(List<Element> elements) {
		this.elements = elements;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}


}
