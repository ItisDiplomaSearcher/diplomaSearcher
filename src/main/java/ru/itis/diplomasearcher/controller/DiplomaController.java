package ru.itis.diplomasearcher.controller;

import org.elasticsearch.action.search.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.*;
import ru.itis.diplomasearcher.model.Diploma;
import ru.itis.diplomasearcher.parser.GsonParser;
import ru.itis.diplomasearcher.service.DiplomaElasticsearchService;
import ru.itis.diplomasearcher.service.DiplomasService;

import java.io.IOException;
import java.util.List;

@RestController
public class DiplomaController {

	private final DiplomasService diplomasService;

	private final DiplomaElasticsearchService diplomaElasticsearchService;

	@Autowired
	public DiplomaController(DiplomasService diplomasService, ElasticsearchOperations elasticsearchOperations,
							 DiplomaElasticsearchService diplomaElasticsearchService) {
		this.diplomasService = diplomasService;
		this.diplomaElasticsearchService = diplomaElasticsearchService;
	}

	@GetMapping("/diploma")
	public List<Diploma> findAll(){
		return null;
	}

	@PostMapping("/diploma")
	public Diploma saveDiploma(@RequestBody Diploma diploma){
		try {
			String diplomaText = diploma.getContentsList() + " " + diploma.getMainPart() + " " + diploma.getLiterature();
			diploma.setText(diplomaText);
			diplomasService.saveDiploma(diploma);
			return diplomaElasticsearchService.updateDiploma(diploma);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/diploma/searchByDiplomaText/{query}")
	public List<Diploma> searchByDiplomaText(@PathVariable String query){
		try {
			return diplomaElasticsearchService.searchByDiplomaText(query);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/diploma/search/")
	public List<Diploma> search(@RequestBody String json){
		try {
			GsonParser gsonParser = new GsonParser(json);
			SearchRequest searchRequest = gsonParser.getFilterSet().getQuery();
			return diplomaElasticsearchService.search(searchRequest);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
