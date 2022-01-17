package com.sclw.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sclw.dto.FotoNewDTO;
import com.sclw.exception.DataIntegrityException;
import com.sclw.exception.ObjectNotFoundException;
import com.sclw.model.Foto;
import com.sclw.model.FotoPK;
import com.sclw.model.Laudo;
import com.sclw.model.LaudoPK;
import com.sclw.repository.FotoRepository;

@Service
public class FotoService {
	
	private static final Logger LOG = LogManager.getLogger(FotoService.class);

	@Autowired
	FotoRepository fotoRepository;
	
	//Capture the photo
	public Foto findById(Integer laudo_id, Integer laudo_item, Integer id) {
		Foto obj = fotoRepository.findByIdLaudoIdIdAndIdLaudoIdItemAndIdId(laudo_id, laudo_item, id);
		if (obj==null)
			throw new ObjectNotFoundException("Objeto não encontrado! laudo_id: " + laudo_id + ",laudo_item: " + laudo_item + ",id: " + id + ", Tipo: " + FotoService.class.getName());
		return obj;
	}
	
	//Capture all the photos from a laudo
	public List<Foto> findAllById(Integer laudo_id, Integer laudo_item) {
		LOG.info("Capture all the photos from a laudo...");
		List<Foto> list = fotoRepository.findAllByIdLaudoIdIdAndIdLaudoIdItemOrderByIdId(laudo_id, laudo_item);
		LOG.info("Capturadas!");
		return list;
	}
	
	public Foto fromDTO(FotoNewDTO newObj) {		
		LaudoPK laudoPK = new LaudoPK();
		laudoPK.setId(newObj.getLaudoId());
		laudoPK.setItem(newObj.getLaudoItem());
		Laudo laudo = new Laudo();
		laudo.setId(laudoPK);
		
		FotoPK fotopk = new FotoPK();
		if (newObj.getId()==null) 
			fotopk.setId(null);
		else
			fotopk.setId(newObj.getId());
		fotopk.setLaudo(laudo);
		Foto obj = new Foto();		
		obj.setId(fotopk);
		obj.setFrase(newObj.getFrase());
		obj.setGrande(newObj.getGrande());
		obj.setPagina1(newObj.getPagina1());
		obj.setPath(newObj.getPath());
		obj.setTema(newObj.getTema());
		return obj;
	}
	
	public Foto insert(FotoNewDTO newObj) {
		LOG.info("Insert photo");
		if (newObj==null || newObj.getPath()==null)
			throw new DataIntegrityException("Dados da foto não informado!");		
		Foto foto = fromDTO(newObj);
		Integer maxId = 0;
		if (foto.getId().getId()==null) {
			//Foto maxObj = fotoRepository.findFirstByIdLaudoIdIdAndIdLaudoIdItemOrderByIdIdDesc(foto.getId().getLaudo().getId().getId(),foto.getId().getLaudo().getId().getItem());
			maxId = fotoRepository.getMaxId(newObj.getLaudoId(), newObj.getLaudoItem());
			if (maxId==null) 
				maxId=0;
		}
		maxId++;
		foto.getId().setId(maxId);
		String path = foto.getPath() + "_" +  String.format("%03d", foto.getId().getId()) + ".jpg";
		foto.setPath(path);
		return fotoRepository.save(foto);
	}
	
	public Foto update(FotoNewDTO newObj) {
		if (newObj.getLaudoId()==null || newObj.getLaudoItem()==null || newObj.getId()==null)
			throw new DataIntegrityException("Objeto de atualizacao nulo!"); 
		Foto obj = fromDTO(newObj);
		return fotoRepository.save(obj);
	}
	
	public void delete(FotoNewDTO newObj) {
		if (newObj.getLaudoId()==null || newObj.getLaudoItem()==null || newObj.getId()==null)
			throw new DataIntegrityException("Objeto de delecao nulo!"); 
		Foto obj = fromDTO(newObj);
		fotoRepository.delete(obj);
	}
}
