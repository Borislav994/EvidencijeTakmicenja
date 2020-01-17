package jwd.EvidencijaTakmicenja.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.EvidencijaTakmicenja.model.Ucesnik;

public interface UcesnikService {
	
	Ucesnik findOne(Long id);

	Page<Ucesnik> findAll(int pageNum);

	Ucesnik save(Ucesnik ucesnik);

	void delete(Long id);

	List<Ucesnik> findByTakmicenjeId(Long takmicenjeId);
	
	Page<Ucesnik> search(
			@Param("naziv") String naziv, 
			@Param("takmicenjeNaziv") String takmicenjeNaziv, 
			int pageNum);
	
	

}
