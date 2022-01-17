package com.sclw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sclw.dto.FotoNewDTO;
import com.sclw.model.Foto;
import com.sclw.service.FotoService;

@Controller
@RequestMapping(value = "/fotos")
public class FotoController {

	@Autowired
	private FotoService fotoService;
	
	@GetMapping
	public ResponseEntity<Foto> findById(
			@RequestParam(value="laudoId") Integer laudoId,
			@RequestParam(value="laudoItem") Integer laudoItem,
			@RequestParam(value="id") Integer id) {
		Foto obj = fotoService.findById(laudoId, laudoItem, id);
		if (obj==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Foto>> findAllById(
			@RequestParam(value="laudoId") Integer laudoId,
			@RequestParam(value="laudoItem") Integer laudoItem) {
		List<Foto> obj = fotoService.findAllById(laudoId, laudoItem);
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping
	public ResponseEntity<String> insert(@Valid @RequestBody FotoNewDTO newObj) {
		Foto obj = fotoService.insert(newObj);
		/*URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("_img={path}").buildAndExpand(
				obj.getPath()).toUri(); 
		return ResponseEntity.created(uri).build();	*/
		return new ResponseEntity<String>(obj.getPath(), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Void> update(@Valid @RequestBody FotoNewDTO newObj) {
		fotoService.update(newObj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> delete(@Valid @RequestBody FotoNewDTO newObj) {
		fotoService.delete(newObj);
		return ResponseEntity.noContent().build();
	}
}
