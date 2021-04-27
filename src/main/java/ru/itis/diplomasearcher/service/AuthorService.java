package ru.itis.diplomasearcher.service;

import ru.itis.diplomasearcher.model.Author;
import ru.itis.diplomasearcher.model.Diploma;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
	Optional<Author> findById(Long id);

	List<Author> findAll();

	Author saveAuthor(Author author);

	void deleteById(Long id);
}
