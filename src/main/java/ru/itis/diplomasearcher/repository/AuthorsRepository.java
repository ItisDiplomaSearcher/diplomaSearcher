package ru.itis.diplomasearcher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.itis.diplomasearcher.model.Author;

@Repository
public interface AuthorsRepository extends CrudRepository<Author, Long>, AuthorsRepositoryCustom {
}
