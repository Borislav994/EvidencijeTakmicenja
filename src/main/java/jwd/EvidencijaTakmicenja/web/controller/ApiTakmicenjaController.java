package jwd.EvidencijaTakmicenja.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jwd.EvidencijaTakmicenja.model.Takmicenje;
import jwd.EvidencijaTakmicenja.model.Ucesnik;
import jwd.EvidencijaTakmicenja.service.TakmicenjeService;
import jwd.EvidencijaTakmicenja.service.UcesnikService;
import jwd.EvidencijaTakmicenja.support.TakmicenjeToTakmicenjeDTO;
import jwd.EvidencijaTakmicenja.support.UcesnikToUcesnikDTO;
import jwd.EvidencijaTakmicenja.web.dto.TakmicenjeDTO;
import jwd.EvidencijaTakmicenja.web.dto.UcesnikDTO;

@Controller
@RequestMapping("/api/takmicenja")
public class ApiTakmicenjaController {
	
	@Autowired
	private TakmicenjeService takmicenjeService;
	
	@Autowired
	private UcesnikService ucesnikService;
	
	@Autowired
	private TakmicenjeToTakmicenjeDTO toDTO;
	
	@Autowired
	private UcesnikToUcesnikDTO toDTOu;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TakmicenjeDTO>> get(
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum) {

		Page<Takmicenje> recordsPage = null;

		
			recordsPage = takmicenjeService.findAll(pageNum);
		

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(recordsPage.getTotalPages()));

		return new ResponseEntity<>(toDTO.convert(recordsPage.getContent()), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{rezultat}")
	public ResponseEntity<UcesnikDTO> get(
			@RequestParam(required = false) Long ucesnik1Id,
			@RequestParam(required = false) Long ucesnik2Id,
			@RequestParam(required = false) Long ishodId) {

		Ucesnik recordsPage = null;

		if (ucesnik1Id != null || ucesnik2Id != null || ishodId != null) {
			recordsPage = takmicenjeService.dodajRezultat(ucesnik1Id, ucesnik2Id,ishodId);
		}

		

		return new ResponseEntity<>(toDTOu.convert(recordsPage), HttpStatus.OK);
	}

	
	@RequestMapping(value = "{takmicenjeId}/ucesnici", method = RequestMethod.GET)
	public ResponseEntity<List<UcesnikDTO>> getAllId(@PathVariable Long takmicenjeId){
		List<Ucesnik> ucesnik = ucesnikService.findByTakmicenjeId(takmicenjeId);

		return new ResponseEntity<>(toDTOu.convert(ucesnik), HttpStatus.OK);
	}
	

}
