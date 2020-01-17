package jwd.EvidencijaTakmicenja;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.EvidencijaTakmicenja.model.FormatTakmicenja;
import jwd.EvidencijaTakmicenja.model.Takmicenje;
import jwd.EvidencijaTakmicenja.model.Ucesnik;
import jwd.EvidencijaTakmicenja.service.FormatService;
import jwd.EvidencijaTakmicenja.service.TakmicenjeService;
import jwd.EvidencijaTakmicenja.service.UcesnikService;

@Component
public class TestData {

	@Autowired
	private UcesnikService ucesniciService;

	@Autowired
	private TakmicenjeService takmicenjeService;
	
	@Autowired
	private FormatService formatService;

	@PostConstruct
	public void init() {

		FormatTakmicenja format1 = new FormatTakmicenja();
		format1.setNaziv("Kup");
		format1.setBrojUcesnika(15);
		format1.setGubitak(0);
		format1.setNereseno(1);
		format1.setPobede(2);
		formatService.save(format1);

		FormatTakmicenja format2 = new FormatTakmicenja();
		format2.setNaziv("Liga");
		format2.setBrojUcesnika(14);
		format2.setGubitak(0);
		format2.setNereseno(1);
		format2.setPobede(2);
		formatService.save(format2);

		Takmicenje t1 = new Takmicenje();
		t1.setNaziv("Takmicenje1");
		t1.setFormat(format1);
		takmicenjeService.save(t1);

		Takmicenje t2 = new Takmicenje();
		t2.setNaziv("Takmicenje2");
		t2.setFormat(format2);
		takmicenjeService.save(t2);

		Ucesnik u1 = new Ucesnik();
		u1.setNaziv("Borislav Spasic");
		u1.setMesto("Novi Sad");
		u1.setEmail("borislav@gmail.com");
		u1.setOdigraoSusreta(10);
		u1.setBrBodova(50);
		u1.setTakmicenje(t1);
		ucesniciService.save(u1);
		
		Ucesnik u2 = new Ucesnik();
		u2.setNaziv("Nikola Nikic");
		u2.setMesto("Beograd");
		u2.setEmail("nikla@gmail.com");
		u2.setOdigraoSusreta(11);
		u2.setBrBodova(35);
		u2.setTakmicenje(t2);
		ucesniciService.save(u2);
	}

}
