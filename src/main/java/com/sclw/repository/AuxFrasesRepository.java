package com.sclw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sclw.model.AuxFrases;

public interface AuxFrasesRepository extends JpaRepository<AuxFrases, Integer> {

	List<AuxFrases> findAllByProcedimentoId(Integer procedimentoId);
	AuxFrases findByIdAndProcedimentoId(Integer id, Integer procedimentoId);
}
