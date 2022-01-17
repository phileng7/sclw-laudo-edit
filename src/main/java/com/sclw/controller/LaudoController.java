package com.sclw.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sclw.dto.LaudoUpdateAuxDTO;
import com.sclw.dto.LaudoUpdateConclusaoDTO;
import com.sclw.dto.LaudoUpdateDTO;
import com.sclw.model.Laudo;
import com.sclw.service.LaudoService;

@Controller
@RequestMapping(value = "/laudos")
public class LaudoController {
	
	@Autowired
	LaudoService laudoService;
	
	@PutMapping("/aux")
	public ResponseEntity<String> updateMain(@Valid @RequestBody LaudoUpdateAuxDTO obj) {
		Laudo ld = laudoService.updateLaudoAux(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}/{item}").buildAndExpand(ld.getId().getId(),ld.getId().getItem()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/main")
	public ResponseEntity<String> updateMain(@Valid @RequestBody LaudoUpdateDTO obj) {
		Laudo ld = laudoService.updateMain(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}/{item}").buildAndExpand(ld.getId().getId(),ld.getId().getItem()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/conc")
	public ResponseEntity<String> updateConclusao(@Valid @RequestBody LaudoUpdateConclusaoDTO obj) {
		Laudo ld = laudoService.updateLaudoConclusaoAux(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}/{item}").buildAndExpand(ld.getId().getId(),ld.getId().getItem()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
