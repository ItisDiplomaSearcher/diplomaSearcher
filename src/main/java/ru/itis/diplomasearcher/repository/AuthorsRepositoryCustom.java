package ru.itis.diplomasearcher.repository;

import ru.itis.diplomasearcher.model.Author;

import java.util.Optional;

public interface AuthorsRepositoryCustom {
	Optional<Author> getByFullName(String firstName, String lastName, String patronymic);
}
