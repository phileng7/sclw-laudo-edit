package com.sclw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sclw.model.AuxTemas;
import com.sclw.service.AuxTemasService;

@Controller
@RequestMapping(value="/auxtemas")
public class AuxTemasController {

	@Autowired
	AuxTemasService temasService;
	
	@GetMapping("/{tipoExameId}")
	public ResponseEntity<List<AuxTemas>> findAllByTipoExameId(@PathVariable Integer tipoExameId) {
		List<AuxTemas> list = temasService.findAllByTipoExameId(tipoExameId);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity<AuxTemas> findAllByIdAndAuxTipoExameTemasId(@RequestParam Integer id, @RequestParam Integer tipoExameId) {
		AuxTemas obj = temasService.findByIdAndTpExame(id, tipoExameId);
		return ResponseEntity.ok().body(obj);
	}
}
