package com.gsnotes.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsnotes.bo.Element;
import com.gsnotes.dao.IElementDao;
import com.gsnotes.services.IElementService;
@Service
@Transactional
public class ElementServiceImpl implements IElementService{
@Autowired
	IElementDao elementdao;

@Override
public void AjouterElement(Element element) {
	elementdao.save(element);
}

@Override
public void ModifierElement(Element element) {
	elementdao.save(element);

	
}

@Override
public List<Element> getAllElement() {
	List<Element> list=elementdao.findAll();
	return list;
}

@Override
public void deleteElement(Long id) {
	elementdao.deleteById(id);	
}

@Override
public Element getElementById(Long id) {
	Element e=elementdao.getById(id);
	return e;
}

@Override
public Element getElementByCode(String code) {
	Element e=elementdao.getElementByCode(code);
	return e;
}


}
