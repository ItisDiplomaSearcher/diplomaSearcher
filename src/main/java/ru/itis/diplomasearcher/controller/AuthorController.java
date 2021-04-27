package ru.itis.diplomasearcher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.diplomasearcher.model.Author;
import ru.itis.diplomasearcher.service.AuthorService;

import java.util.List;

@RestController
public class AuthorController {

	private final AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@GetMapping("/authors")
	public List<Author> findAll(){
		return authorService.findAll();
	}

	@GetMapping("/authors/{id}")
	public Author getById(@PathVariable Long id){
		return authorService.findById(id).orElse(new Author());
	}
}
