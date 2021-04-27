package ru.itis.diplomasearcher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.diplomasearcher.model.Diploma;
import ru.itis.diplomasearcher.service.DiplomasService;

import java.util.List;

@RestController
public class DiplomaController {

	private final DiplomasService diplomasService;

	@Autowired
	public DiplomaController(DiplomasService diplomasService) {
		this.diplomasService = diplomasService;
	}


	@GetMapping("/diplomas")
	public List<Diploma> findAll(){
		return diplomasService.findAll();
	}

	@PostMapping("/diplomas")
	public Diploma saveDiploma(@RequestBody Diploma newDiploma){
		return diplomasService.saveDiploma(newDiploma);
	}

	@GetMapping("/diplomas/{id}")
	public Diploma findById(@PathVariable Long id){
		return diplomasService.findById(id).orElse(new Diploma());
	}
}
