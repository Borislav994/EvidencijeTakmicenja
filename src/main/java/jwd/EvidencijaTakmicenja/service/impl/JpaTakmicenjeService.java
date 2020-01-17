package jwd.EvidencijaTakmicenja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.EvidencijaTakmicenja.model.Takmicenje;
import jwd.EvidencijaTakmicenja.model.Ucesnik;
import jwd.EvidencijaTakmicenja.repository.TakmicenjeRepository;
import jwd.EvidencijaTakmicenja.repository.UcesnikRepository;
import jwd.EvidencijaTakmicenja.service.TakmicenjeService;

@Service
public class JpaTakmicenjeService  implements TakmicenjeService {
	
	@Autowired
	private TakmicenjeRepository takmicenjeRepository;
	
	@Autowired
	private UcesnikRepository ucRep;

	@Override
	public Takmicenje findOne(Long id) {
		// TODO Auto-generated method stub
		return takmicenjeRepository.findOne(id);
	}

	@Override
	public Page<Takmicenje> findAll(int pageNum) {
		// TODO Auto-generated method stub
		return takmicenjeRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Takmicenje save(Takmicenje takmicenje) {
		// TODO Auto-generated method stub
		return takmicenjeRepository.save(takmicenje);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		takmicenjeRepository.delete(id);
	}

	@Override
	public List<Takmicenje> findByFormatId(Long formatId) {
		// TODO Auto-generated method stub
		return takmicenjeRepository.findByFormatId(formatId);
	}

	
		@Override
		public Ucesnik dodajRezultat(Long prviId, Long drugiId, Long ishodId) {
			// TODO Auto-generated method stub
			Ucesnik uc1 = ucRep.findOne(prviId);
			Ucesnik uc2 = ucRep.findOne(drugiId);
			if(uc1 == uc2) {
				Exception ex = new Exception();
				ex.printStackTrace();
			}
			
			if(ishodId == 0) {
				uc1.setOdigraoSusreta(uc1.getOdigraoSusreta() + 1);
				uc1.setBrBodova(uc1.getBrBodova() + uc1.getTakmicenje().getFormat().getNereseno());
				uc2.setOdigraoSusreta(uc2.getOdigraoSusreta() + 1);
				uc2.setBrBodova(uc2.getBrBodova() + uc2.getTakmicenje().getFormat().getNereseno());
			}else if(ishodId == 1) {
				uc1.setOdigraoSusreta(uc1.getOdigraoSusreta() + 1);
				uc1.setBrBodova(uc1.getBrBodova() + uc1.getTakmicenje().getFormat().getPobede());
				uc2.setOdigraoSusreta(uc2.getOdigraoSusreta() + 1);
			} else if(ishodId == 2) {
				uc1.setOdigraoSusreta(uc1.getOdigraoSusreta() + 1);
				uc2.setOdigraoSusreta(uc2.getOdigraoSusreta() + 1);
				uc2.setBrBodova(uc2.getBrBodova() + uc2.getTakmicenje().getFormat().getPobede());
			}
			
			ucRep.save(uc1);
			ucRep.save(uc2);
			
			return uc1;
		}
	

}
