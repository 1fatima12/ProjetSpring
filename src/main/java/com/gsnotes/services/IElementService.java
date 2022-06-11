package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Element;
import com.gsnotes.bo.Filiere;

public interface IElementService {
	public void AjouterElement(Element element);

	public void ModifierElement(Element element);

	public List<Element> getAllElement();

	public void deleteElement(Long id);

	public Element getElementById(Long id);
	public Element getElementByCode(String code);

}
