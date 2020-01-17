package jwd.EvidencijaTakmicenja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.EvidencijaTakmicenja.model.FormatTakmicenja;
import jwd.EvidencijaTakmicenja.repository.FormatRepository;
import jwd.EvidencijaTakmicenja.service.FormatService;

@Service
public class JpaFormatService implements FormatService{
	
	@Autowired
	private FormatRepository formatRepository;

	@Override
	public FormatTakmicenja findOne(Long id) {
		// TODO Auto-generated method stub
		return formatRepository.findOne(id);
	}

	@Override
	public List<FormatTakmicenja> findAll() {
		// TODO Auto-generated method stub
		return formatRepository.findAll();
	}

	@Override
	public FormatTakmicenja save(FormatTakmicenja takmicenje) {
		// TODO Auto-generated method stub
		return formatRepository.save(takmicenje);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		formatRepository.delete(id);
	}

}
