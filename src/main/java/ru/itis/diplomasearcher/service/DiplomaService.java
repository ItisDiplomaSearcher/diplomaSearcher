package ru.itis.diplomasearcher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.diplomasearcher.repository.DiplomaRepository;

@Service
public class DiplomaService {

	private final DiplomaRepository diplomaRepository;

	@Autowired
	public DiplomaService(DiplomaRepository diplomaRepository){
		this.diplomaRepository = diplomaRepository;
	}
}
