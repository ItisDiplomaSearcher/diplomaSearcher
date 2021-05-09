package ru.itis.diplomasearcher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.diplomasearcher.model.Diploma;
import ru.itis.diplomasearcher.repository.DiplomaRepository;
import ru.itis.diplomasearcher.service.DiplomasService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiplomaServiceImpl implements DiplomasService {

	private final DiplomaRepository diplomaRepository;


	@Autowired
	public DiplomaServiceImpl(DiplomaRepository diplomaRepository){
		this.diplomaRepository = diplomaRepository;
	}


	@Override
	public Optional<Diploma> findById(Long id) {
		return diplomaRepository.findById(id);
	}

	@Override
	public List<Diploma> findAll() {
		List<Diploma> diplomas = new ArrayList<>();
		diplomaRepository.findAll().forEach(diplomas::add);
		return diplomas;
	}

	@Override
	public Diploma saveDiploma(Diploma diploma) {
		return diplomaRepository.save(diploma);
	}

	@Override
	public void deleteById(Long id) {
		diplomaRepository.deleteById(id);
	}
}
