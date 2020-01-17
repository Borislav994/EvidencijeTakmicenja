package jwd.EvidencijaTakmicenja.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jwd.EvidencijaTakmicenja.model.Ucesnik;
import jwd.EvidencijaTakmicenja.service.UcesnikService;
import jwd.EvidencijaTakmicenja.support.UcesnikDTOtoUcesnik;
import jwd.EvidencijaTakmicenja.support.UcesnikToUcesnikDTO;
import jwd.EvidencijaTakmicenja.web.dto.UcesnikDTO;


@Controller
@RequestMapping("/api/ucesnici")
public class ApiUcesniciController {

	@Autowired
	private UcesnikService ucesniciService;

	@Autowired
	private UcesnikToUcesnikDTO toDTO;

	@Autowired
	private UcesnikDTOtoUcesnik toUcesnik;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UcesnikDTO>> get(
			@RequestParam(required = false) String naziv,
			@RequestParam(required = false) String takmicenjeNaziv,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum) {

		Page<Ucesnik> recordsPage = null;

		if (naziv != null || takmicenjeNaziv != null) {
			recordsPage = ucesniciService.search(naziv, takmicenjeNaziv, pageNum);
		} else {
			recordsPage = ucesniciService.findAll(pageNum);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(recordsPage.getTotalPages()));

		return new ResponseEntity<>(toDTO.convert(recordsPage.getContent()), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UcesnikDTO> get(@PathVariable Long id) {

		Ucesnik ucesnik = ucesniciService.findOne(id);

		return new ResponseEntity<>(toDTO.convert(ucesnik), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UcesnikDTO> add(@Validated @RequestBody UcesnikDTO newUcesnik) {

		Ucesnik persisted = ucesniciService.save(toUcesnik.convert(newUcesnik));

		ucesniciService.save(persisted);

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.CREATED);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<UcesnikDTO> edit(@PathVariable Long id, @RequestBody UcesnikDTO editedArtikal) {

		if (id == null || !id.equals(editedArtikal.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Ucesnik persisted = ucesniciService.save(toUcesnik.convert(editedArtikal));

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UcesnikDTO> delete(@PathVariable Long id) {
		Ucesnik ar = ucesniciService.findOne(id);
		if (ar != null) {
			ucesniciService.delete(id);

			return new ResponseEntity<>(toDTO.convert(ar), HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

	}
	
	

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
