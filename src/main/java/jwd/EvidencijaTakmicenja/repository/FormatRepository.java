package jwd.EvidencijaTakmicenja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.EvidencijaTakmicenja.model.FormatTakmicenja;

@Repository
public interface FormatRepository extends JpaRepository<FormatTakmicenja, Long >{
	
	

}
