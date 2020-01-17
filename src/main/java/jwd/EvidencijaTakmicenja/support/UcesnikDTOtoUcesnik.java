package jwd.EvidencijaTakmicenja.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.EvidencijaTakmicenja.model.Takmicenje;
import jwd.EvidencijaTakmicenja.model.Ucesnik;
import jwd.EvidencijaTakmicenja.service.TakmicenjeService;
import jwd.EvidencijaTakmicenja.service.UcesnikService;
import jwd.EvidencijaTakmicenja.web.dto.UcesnikDTO;


@Component
public class UcesnikDTOtoUcesnik implements Converter<UcesnikDTO, Ucesnik>{
	
	@Autowired
	private TakmicenjeService takmicenjeService;
	
	@Autowired
	private UcesnikService ucesnikService;

	@Override
	public Ucesnik convert(UcesnikDTO ucesnikDTO) {
	Takmicenje takmicenje = takmicenjeService.findOne(ucesnikDTO.getTakmicenjeId());

	if (takmicenje != null) {

		Ucesnik ucesnik = null;

		if (ucesnikDTO.getId() != null) {
			ucesnik = ucesnikService.findOne(ucesnikDTO.getId());
		} else {
			ucesnik = new Ucesnik();
		}

		ucesnik.setId(ucesnikDTO.getId());
		ucesnik.setNaziv(ucesnikDTO.getNaziv());
		ucesnik.setMesto(ucesnikDTO.getMesto());
		ucesnik.setEmail(ucesnikDTO.getEmail());
		ucesnik.setBrBodova(ucesnikDTO.getBrBodova());
		ucesnik.setOdigraoSusreta(ucesnikDTO.getOdigraoSusreta());
		ucesnik.setTakmicenje(takmicenje);

		return ucesnik;
	} else {
		throw new IllegalStateException("Trying to attach to non-existant entities");
	}		
}

public List<Ucesnik> convert(List<UcesnikDTO> artikalsDTOs) {
	List<Ucesnik> ret = new ArrayList<>();

	for (UcesnikDTO artikalDTO : artikalsDTOs) {
		ret.add(convert(artikalDTO));
	}

	return ret;
}
}
