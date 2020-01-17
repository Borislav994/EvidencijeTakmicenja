package jwd.EvidencijaTakmicenja.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.EvidencijaTakmicenja.model.Takmicenje;
import jwd.EvidencijaTakmicenja.model.Ucesnik;


public interface TakmicenjeService {
	
	Takmicenje findOne(Long id);

	Page<Takmicenje> findAll(int pageNum);

	Takmicenje save(Takmicenje takmicenje);

	void delete(Long id);

	List<Takmicenje> findByFormatId(Long formatId);
	
	Ucesnik dodajRezultat(
			@Param("prviId") Long prviId,
			@Param("drugiId") Long drugiId,
			@Param("ishodId") Long ishodId);


}
