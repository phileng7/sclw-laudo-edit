package com.sclw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sclw.model.AuxTemas;

public interface AuxTemasRepository extends JpaRepository<AuxTemas, Integer> {

	List<AuxTemas> findAllByAuxTipoExameTemasId(Integer id);
	AuxTemas findByIdAndAuxTipoExameTemasId(Integer id, Integer tipoExame);
}
