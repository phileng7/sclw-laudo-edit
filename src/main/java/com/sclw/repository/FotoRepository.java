package com.sclw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sclw.model.Foto;
import com.sclw.model.FotoPK;

@Repository
public interface FotoRepository extends JpaRepository<Foto, FotoPK> {

	Foto findByIdLaudoIdIdAndIdLaudoIdItemAndIdId(Integer laudo_id, Integer laudo_item, Integer id);

	List<Foto> findAllByIdLaudoIdIdAndIdLaudoIdItemOrderByIdId(Integer laudo_id, Integer laudo_item);
	
	//Foto findFirstByIdLaudoIdIdAndIdLaudoIdItemOrderByIdIdDesc(Integer laudo_id, Integer laudo_item);		//, Integer id);
	@Transactional(readOnly=true)
	@Query("SELECT MAX(ft.id.id) FROM Foto ft WHERE ft.id.laudo.id.id = :laudoId AND ft.id.laudo.id.item = :laudoItem")
	Integer getMaxId(@Param("laudoId") Integer laudoId, @Param("laudoItem") Integer laudoItem);
}
