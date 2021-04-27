package ru.itis.diplomasearcher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.diplomasearcher.model.Author;
import ru.itis.diplomasearcher.repository.AuthorsRepository;
import ru.itis.diplomasearcher.service.AuthorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

	private final AuthorsRepository authorsRepository;

	@Autowired
	public AuthorServiceImpl(AuthorsRepository authorsRepository) {
		this.authorsRepository = authorsRepository;
	}

	@Override
	public Optional<Author> findById(Long id) {
		return authorsRepository.findById(id);
	}

	@Override
	public List<Author> findAll() {
		List<Author> authors = new ArrayList<>();
		authorsRepository.findAll().forEach(authors::add);
		return authors;
	}

	@Override
	public Author saveAuthor(Author author) {
		return authorsRepository.save(author);
	}

	@Override
	public void deleteById(Long id) {
		authorsRepository.deleteById(id);
	}
}
