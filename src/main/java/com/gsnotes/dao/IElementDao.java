package com.gsnotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsnotes.bo.Element;

public interface IElementDao extends JpaRepository<Element,Long>{
	public Element getElementByCode(String code);
}
