package com.gsnotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsnotes.bo.Filiere;

public interface IFiliereDao extends JpaRepository<Filiere, Long>{
     public Filiere getFiliereByCodeFiliere(String codeFiliere);
}
