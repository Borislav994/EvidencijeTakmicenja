package jwd.EvidencijaTakmicenja.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.EvidencijaTakmicenja.model.Takmicenje;
import jwd.EvidencijaTakmicenja.web.dto.TakmicenjeDTO;


@Component
public class TakmicenjeToTakmicenjeDTO implements Converter<Takmicenje, TakmicenjeDTO>{

	@Override
	public TakmicenjeDTO convert(Takmicenje takmicenje) {
		TakmicenjeDTO retValue = new TakmicenjeDTO();
		retValue.setId(takmicenje.getId());
		retValue.setNaziv(takmicenje.getNaziv());
		retValue.setFormatId(takmicenje.getFormat().getId());
		retValue.setFormatNaziv(takmicenje.getFormat().getNaziv());;
		return retValue;
	}

	public List<TakmicenjeDTO> convert(List<Takmicenje> takmicenja) {
		List<TakmicenjeDTO> ret = new ArrayList<>();

		for (Takmicenje takmicenje : takmicenja) {
			ret.add(convert(takmicenje));
		}

		return ret;
	}
}
