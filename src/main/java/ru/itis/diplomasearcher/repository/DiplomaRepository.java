package ru.itis.diplomasearcher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.itis.diplomasearcher.model.Diploma;

@Repository
public interface DiplomaRepository extends CrudRepository<Diploma, Long> {
}
