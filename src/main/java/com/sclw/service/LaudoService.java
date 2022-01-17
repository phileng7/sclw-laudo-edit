package com.sclw.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sclw.dto.LaudoUpdateAuxDTO;
import com.sclw.dto.LaudoUpdateConclusaoDTO;
import com.sclw.dto.LaudoUpdateDTO;
import com.sclw.exception.DataIntegrityException;
import com.sclw.exception.ObjectNotFoundException;
import com.sclw.model.Laudo;
import com.sclw.model.LaudoPK;
import com.sclw.repository.LaudoRepository;

@Service
public class LaudoService {
	
	private static final Logger LOG = LogManager.getLogger(LaudoService.class);

	@Autowired 
	LaudoRepository laudoRepository;
	
	public Laudo findByIdItem(Integer id, Integer item) {
		Optional<Laudo> obj = laudoRepository.findById(new LaudoPK(id, item));
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + LaudoService.class.getName()));
	}
	
	public Laudo updateLaudoAux(LaudoUpdateAuxDTO obj) {
		if (obj==null || obj.getId()==null)
			throw new DataIntegrityException("Update-Objeto de insercao nulo!"); 
		
		LaudoPK ldpk = new LaudoPK(obj.getId(), obj.getItem());
		Optional<Laudo> ld = laudoRepository.findById(ldpk);
		if (ld.get()==null)
			throw new DataIntegrityException("Update not possible because does not exist, ID=" + obj.getId() + ", item=" + obj.getItem());
		if (obj.getGrupoTipoExames()!=null)
			ld.get().setGrupoTipoExames(obj.getGrupoTipoExames());
		if (obj.getGrupoTProcedimentos()!=null)
			ld.get().setGrupoTProcedimentos(obj.getGrupoTProcedimentos());
		if (obj.getMneumonico()!=null)
			ld.get().setMneumonico(obj.getMneumonico());
		return laudoRepository.save(ld.get());
	}
	
	public Laudo updateMain(LaudoUpdateDTO obj) {
		if (obj==null || obj.getId()==null)
			throw new DataIntegrityException("Update-Objeto de insercao nulo!"); 
		
		LaudoPK ldpk = new LaudoPK(obj.getId(), obj.getItem());
		Optional<Laudo> ld = laudoRepository.findById(ldpk);
		if (ld.get()==null)
			throw new DataIntegrityException("Update not possible because does not exist, ID=" + obj.getId() + ", item=" + obj.getItem());
		if (obj.getAltura()!=null)
			ld.get().setAltura(obj.getAltura());
		if (obj.getIdade()!=null)
			ld.get().setIdade(obj.getIdade());
		if (obj.getPeso()!=null)
			ld.get().setPeso(obj.getPeso());
		if (obj.getMneumonico()!=null)
			ld.get().setMneumonico(obj.getMneumonico());
		ld.get().setNovoLaudo("N"); 	//Not a new laudo anymore
		return laudoRepository.save(ld.get());
	}
	
	public Laudo updateLaudoConclusaoAux(LaudoUpdateConclusaoDTO obj) {
		if (obj==null || obj.getId()==null)
			throw new DataIntegrityException("Update-Objeto de insercao nulo!"); 
		
		LaudoPK ldpk = new LaudoPK(obj.getId(), obj.getItem());
		Optional<Laudo> ld = laudoRepository.findById(ldpk);
		if (ld.get()==null)
			throw new DataIntegrityException("Update not possible because does not exist, ID=" + obj.getId() + ", item=" + obj.getItem());
		if (obj.getConclusao()!=null)
			ld.get().setConclusao(obj.getConclusao());
		return laudoRepository.save(ld.get());
	}
	
	public Laudo update(Laudo obj) {
		if (obj==null || obj.getId()==null)
			throw new DataIntegrityException("Update-Objeto de insercao nulo!"); 
		return laudoRepository.save(obj);
	}
}
