package com.sclw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sclw.model.AuxTemas;
import com.sclw.repository.AuxTemasRepository;

@Service
public class AuxTemasService {

	@Autowired
	AuxTemasRepository temasRepository;
	
	public List<AuxTemas> findAllByTipoExameId(Integer tipoExameId) {
		return temasRepository.findAllByAuxTipoExameTemasId(tipoExameId);
	}
	
	public AuxTemas findByIdAndTpExame(Integer id, Integer tipoExameId) {
		return temasRepository.findByIdAndAuxTipoExameTemasId(id, tipoExameId);
	}
}
