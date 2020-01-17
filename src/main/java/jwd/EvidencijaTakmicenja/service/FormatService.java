package jwd.EvidencijaTakmicenja.service;

import java.util.List;


import jwd.EvidencijaTakmicenja.model.FormatTakmicenja;

public interface FormatService {
	FormatTakmicenja findOne(Long id);

	List<FormatTakmicenja> findAll();

	FormatTakmicenja save(FormatTakmicenja takmicenje);

	void delete(Long id);
}
