package jwd.EvidencijaTakmicenja.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.EvidencijaTakmicenja.model.Ucesnik;
import jwd.EvidencijaTakmicenja.web.dto.UcesnikDTO;

@Component
public class UcesnikToUcesnikDTO implements Converter<Ucesnik, UcesnikDTO> {
	@Override
	public UcesnikDTO convert(Ucesnik ucesnik) {
		
		UcesnikDTO retValue = new UcesnikDTO();
		retValue.setId(ucesnik.getId());
		retValue.setNaziv(ucesnik.getNaziv());
		retValue.setEmail(ucesnik.getEmail());
		retValue.setMesto(ucesnik.getMesto());
		retValue.setBrBodova(ucesnik.getBrBodova());
		retValue.setOdigraoSusreta(ucesnik.getOdigraoSusreta());
		retValue.setTakmicenjeId(ucesnik.getTakmicenje().getId());
		retValue.setTakmicenjeNaziv(ucesnik.getTakmicenje().getNaziv());
		return retValue;
	}

	public List<UcesnikDTO> convert(List<Ucesnik> ucesnici) {
		List<UcesnikDTO> ret = new ArrayList<>();

		for (Ucesnik ucesnik : ucesnici) {
			ret.add(convert(ucesnik));
		}

		return ret;
	}
}
