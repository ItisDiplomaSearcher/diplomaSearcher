package ru.itis.diplomasearcher.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itis.diplomasearcher.model.Diploma;

public interface DiplomaRepository extends CrudRepository<Diploma, Long> {
}
