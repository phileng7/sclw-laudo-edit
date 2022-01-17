package com.sclw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sclw.model.AuxFrases;
import com.sclw.service.AuxFrasesService;

@Controller
@RequestMapping(value="/auxfrases")
public class AuxFrasesController {

	@Autowired
	AuxFrasesService frasesService;
	
	@GetMapping("/{procedimentoId}")
	public ResponseEntity<List<AuxFrases>> findAllByTipoExameId(@PathVariable Integer procedimentoId) {
		List<AuxFrases> list = frasesService.findAllByProcedimentoId(procedimentoId);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity<AuxFrases> findAllByIdAndAuxTipoExameTemasId(@RequestParam Integer id, @RequestParam Integer procedimentoId) {
		AuxFrases obj = frasesService.findByIdAndProced(id, procedimentoId);
		return ResponseEntity.ok().body(obj);
	}
}
