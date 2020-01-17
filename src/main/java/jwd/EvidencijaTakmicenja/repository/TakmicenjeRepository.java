package jwd.EvidencijaTakmicenja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.EvidencijaTakmicenja.model.FormatTakmicenja;
import jwd.EvidencijaTakmicenja.model.Takmicenje;


@Repository
public interface TakmicenjeRepository extends JpaRepository<Takmicenje, Long > {
	
	
	
	List<Takmicenje> findByFormatId(Long formatId);

	List<Takmicenje> findByFormat(FormatTakmicenja formatId);


}
