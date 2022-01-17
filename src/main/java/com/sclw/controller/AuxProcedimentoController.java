package com.sclw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sclw.model.AuxProcedimento;
import com.sclw.service.AuxProcedimentoService;

@Controller
@RequestMapping(value="/auxprocedimentos")
public class AuxProcedimentoController {

	@Autowired
	AuxProcedimentoService procedimentoService;
	
	@GetMapping("/{tipoExameId}")
	public ResponseEntity<List<AuxProcedimento>> findAllByTipoExame(@PathVariable Integer tipoExameId) {
		List<AuxProcedimento> lista = procedimentoService.findAllByTipoExame(tipoExameId);
		return ResponseEntity.ok().body(lista);
	}
}
