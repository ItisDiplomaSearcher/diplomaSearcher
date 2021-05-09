package ru.itis.diplomasearcher.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itis.diplomasearcher.model.Diploma;
import ru.itis.diplomasearcher.model.EducationLevel;
import ru.itis.diplomasearcher.service.DiplomaElasticsearchService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DiplomaElasticsearchServiceImpl implements DiplomaElasticsearchService {

	private final RestHighLevelClient esClient;
	private final String INDEX_NAME;
	private final ObjectMapper mapper = new ObjectMapper();

	public DiplomaElasticsearchServiceImpl(@Qualifier("client") RestHighLevelClient esClient,
										   @Value("${elasticsearch.index.diploma.name}") String indexName) {
		this.esClient = esClient;
		this.INDEX_NAME = indexName;
	}

	@Override
	public Diploma updateDiploma(Diploma diploma) throws IOException {
		IndexRequest indexRequest = new IndexRequest(INDEX_NAME);
		indexRequest.id(diploma.getId() + "");
		indexRequest.source(mapper.writeValueAsString(diploma), XContentType.JSON);

		esClient.index(indexRequest, RequestOptions.DEFAULT);
		return diploma;
	}

	@Override
	public List<Diploma> search(SearchRequest searchRequest) throws IOException {
		SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);

		List<Diploma> diplomas = new ArrayList<>();
		for (SearchHit hit : searchResponse.getHits().getHits()) {
			Map<String, Object> sourceAsMap = hit.getSourceAsMap();
			Long id = new Long((Integer) sourceAsMap.get("id"));
			String title = (String) sourceAsMap.get("title");
			EducationLevel level = Enum.valueOf(EducationLevel.class, (String) sourceAsMap.get("level"));
			Integer graduationYear = (Integer) sourceAsMap.get("graduationYear");
			String text = (String) sourceAsMap.get("text");
			String author = (String) sourceAsMap.get("author");
			String advisor = (String) sourceAsMap.get("advisor");


			Diploma diploma = new Diploma(id, title, graduationYear, level, text, author, advisor);
			diplomas.add(diploma);
		}

		return diplomas;
	}


	@Override
	public List<Diploma> searchByDiplomaText(String searchString) throws IOException {
		SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchQuery("text", searchString));

		searchRequest.source(searchSourceBuilder);
		return search(searchRequest);
	}
}
