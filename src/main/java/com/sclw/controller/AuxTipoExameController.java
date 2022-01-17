package com.sclw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sclw.model.AuxTipoExame;
import com.sclw.service.AuxTipoExameService;

@Controller
@RequestMapping(value="/auxtipoexames")
public class AuxTipoExameController {

	@Autowired
	AuxTipoExameService tipoExameService;
	
	@GetMapping
	public ResponseEntity<List<AuxTipoExame>> findAll() {
		List<AuxTipoExame> list = tipoExameService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AuxTipoExame> findAllById(@PathVariable Integer id) {
		AuxTipoExame obj = tipoExameService.findById(id);
		return ResponseEntity.ok(obj);
	}
}
