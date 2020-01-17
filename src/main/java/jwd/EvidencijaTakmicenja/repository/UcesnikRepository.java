package jwd.EvidencijaTakmicenja.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.EvidencijaTakmicenja.model.Takmicenje;
import jwd.EvidencijaTakmicenja.model.Ucesnik;

@Repository
public interface UcesnikRepository extends JpaRepository<Ucesnik, Long > {
	List<Ucesnik> findByTakmicenjeId(Long takmicenjeId);

	List<Ucesnik> Takmicenje(Takmicenje takmicenje);
	
	@Query("SELECT a FROM Ucesnik a WHERE "
			+ "(:naziv IS NULL or a.naziv like :naziv ) AND "
			+ "(:takmicenjeNaziv IS NULL OR a.takmicenje.naziv like :takmicenjeNaziv)"
			)
	Page<Ucesnik> search(
			@Param("naziv") String naziv, 
			@Param("takmicenjeNaziv") String takmicenjeNaziv, 
			Pageable pageRequest);


}
