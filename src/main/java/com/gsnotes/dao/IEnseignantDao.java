package com.gsnotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsnotes.bo.Enseignant;

public interface IEnseignantDao extends JpaRepository<Enseignant, Long>{

}
