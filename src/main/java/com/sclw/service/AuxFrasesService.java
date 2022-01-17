package com.sclw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sclw.model.AuxFrases;
import com.sclw.repository.AuxFrasesRepository;

@Service
public class AuxFrasesService {

	@Autowired
	AuxFrasesRepository frasesRepository;
	
	public List<AuxFrases> findAllByProcedimentoId(Integer procedimentoId) {
		return frasesRepository.findAllByProcedimentoId(procedimentoId);
	}
	
	public AuxFrases findByIdAndProced(Integer id, Integer procedimentoId) {
		return frasesRepository.findByIdAndProcedimentoId(id, procedimentoId);
	}
}
