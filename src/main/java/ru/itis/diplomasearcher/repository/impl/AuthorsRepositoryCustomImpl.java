package ru.itis.diplomasearcher.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.diplomasearcher.model.Author;
import ru.itis.diplomasearcher.repository.AuthorsRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public class AuthorsRepositoryCustomImpl implements AuthorsRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Optional<Author> getByFullName(String firstName, String lastName, String patronymic) {

		TypedQuery<Author> query = entityManager.createQuery("SELECT a FROM Author a " +
				"WHERE a.firstName = ?1 AND a.lastName = ?2 AND a.patronymic = ?3", Author.class)
				.setParameter(1, firstName)
				.setParameter(2, lastName)
				.setParameter(3, patronymic);

		return query.getResultStream().findFirst();
	}
}
