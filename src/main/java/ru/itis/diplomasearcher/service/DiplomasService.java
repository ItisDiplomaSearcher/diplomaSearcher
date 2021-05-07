package ru.itis.diplomasearcher.service;

import ru.itis.diplomasearcher.model.Diploma;

import java.util.List;
import java.util.Optional;

public interface DiplomasService {

	Optional<Diploma> findById(Long id);

	List<Diploma> findAll();

	Diploma saveDiploma(Diploma diploma);

	void deleteById(Long id);
}
