package ru.itis.diplomasearcher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.diplomasearcher.model.Diploma;
import ru.itis.diplomasearcher.repository.DiplomaRepository;
import ru.itis.diplomasearcher.service.DiplomaElasticsearchService;
import ru.itis.diplomasearcher.service.DiplomasService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiplomaServiceImpl implements DiplomasService {

	private final DiplomaRepository diplomaRepository;
	private final DiplomaElasticsearchService diplomaSearchService;


	@Autowired
	public DiplomaServiceImpl(DiplomaRepository diplomaRepository,
							  DiplomaElasticsearchService diplomaSearchService){
		this.diplomaRepository = diplomaRepository;
		this.diplomaSearchService = diplomaSearchService;
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

	/**
	 * Must be transactional to prevent data inconsistency
	 */
	@Transactional
	@Override
	public Diploma saveDiploma(Diploma diploma) throws IOException {
		updateDiplomaText(diploma);
		diplomaSearchService.updateDiploma(diploma);
		return diplomaRepository.save(diploma);
	}

	private void updateDiplomaText(Diploma diploma) {
		String diplomaText = String.join(" ",
				diploma.getContentsList(),
				diploma.getMainPart(),
				diploma.getLiterature());
		diploma.setText(diplomaText);
	}

	@Override
	public void deleteById(Long id) {
		diplomaRepository.deleteById(id);
	}
}
