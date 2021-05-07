package ru.itis.diplomasearcher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.*;
import ru.itis.diplomasearcher.model.Diploma;
import ru.itis.diplomasearcher.service.DiplomaElasticsearchService;
import ru.itis.diplomasearcher.service.DiplomasService;

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


	@GetMapping("/diplomas")
	public List<Diploma> findAll(){
		return diplomasService.findAll();
	}

	@PostMapping("/diplomas")
	public Diploma saveDiploma(@RequestBody Diploma diploma){
		try {
			diplomasService.saveDiploma(diploma);
			return diplomaElasticsearchService.updateDiploma(diploma);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/diplomas/{id}")
	public Diploma findById(@PathVariable Long id){
		return diplomasService.findById(id).orElse(new Diploma());
	}

	@GetMapping("/diplomas/query/{query}")
	public List<Diploma> findByQuery(@PathVariable String query){
		try {
			return diplomaElasticsearchService.search(query);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
