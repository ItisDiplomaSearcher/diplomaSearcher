package ru.itis.diplomasearcher.service;

import org.elasticsearch.action.search.SearchRequest;
import ru.itis.diplomasearcher.model.Diploma;

import java.io.IOException;
import java.util.List;

public interface DiplomaElasticsearchService {

	Diploma updateDiploma(Diploma diploma) throws IOException;

	List<Diploma> search(SearchRequest searchRequest) throws IOException;

	List<Diploma> searchByDiplomaText(String searchString) throws IOException;
}
