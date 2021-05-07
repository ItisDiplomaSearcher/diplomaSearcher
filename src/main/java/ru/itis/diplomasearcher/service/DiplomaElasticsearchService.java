package ru.itis.diplomasearcher.service;

import ru.itis.diplomasearcher.model.Diploma;

import java.util.List;

public interface DiplomaElasticsearchService {

	Diploma updateDiploma(Diploma diploma) throws Exception;

	List<Diploma> search(String searchString) throws Exception;
}
