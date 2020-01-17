package jwd.EvidencijaTakmicenja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import jwd.EvidencijaTakmicenja.model.Ucesnik;
import jwd.EvidencijaTakmicenja.repository.UcesnikRepository;
import jwd.EvidencijaTakmicenja.service.UcesnikService;

@Service
public class JpaUcesnikService implements UcesnikService {
	
	@Autowired
	private UcesnikRepository ucesnikRepository;

	@Override
	public Ucesnik findOne(Long id) {
		// TODO Auto-generated method stub
		return ucesnikRepository.findOne(id);
	}

	@Override
	public Page<Ucesnik> findAll(int pageNum) {
		// TODO Auto-generated method stub
		return ucesnikRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Ucesnik save(Ucesnik ucesnik) {
		// TODO Auto-generated method stub
		return ucesnikRepository.save(ucesnik);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ucesnikRepository.delete(id);
	}

	@Override
	public List<Ucesnik> findByTakmicenjeId(Long takmicenjeId) {
		// TODO Auto-generated method stub
		return ucesnikRepository.findByTakmicenjeId(takmicenjeId);
	}

	@Override
	public Page<Ucesnik> search(String naziv, String takmicenjeNaziv, int pageNum) {
		if(naziv != null) {
			naziv = '%' + naziv + '%';
		}
		if(takmicenjeNaziv != null) {
			takmicenjeNaziv = '%' + takmicenjeNaziv + '%';
		}
		return ucesnikRepository.search(naziv, takmicenjeNaziv, new PageRequest(pageNum, 5));
	}

	

}
