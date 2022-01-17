package com.sclw.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sclw.dto.MedicoesDTO;
import com.sclw.model.Medicoes;
import com.sclw.service.MedicoesService;

@Controller
@RequestMapping(value="/medicoes")
public class MedicoesController {

	@Autowired
	MedicoesService medicoesService;
	
	@GetMapping
	public ResponseEntity<List<Medicoes>> findAllByLaudo(@RequestParam (value="laudo_id") Integer laudo_id, 
														@RequestParam (value="laudo_item") Integer laudo_item) {
		List<Medicoes> list = medicoesService.findAllByLaudoIdAndLaudoItem(laudo_id, laudo_item);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping 
	public ResponseEntity<String> insert(@Valid @RequestBody MedicoesDTO objDTO) {
		Medicoes obj = medicoesService.insert(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping 
	public ResponseEntity<Void> update(@Valid @RequestBody Medicoes obj) {
		medicoesService.update(obj);
		return ResponseEntity.noContent().build();
	}
}
