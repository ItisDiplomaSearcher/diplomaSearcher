package ru.itis.diplomasearcher.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.diplomasearcher.commons.exception.ResourceNotFoundException;
import ru.itis.diplomasearcher.model.Diploma;
import ru.itis.diplomasearcher.service.DiplomaElasticsearchService;
import ru.itis.diplomasearcher.service.DiplomasService;
import ru.itis.diplomasearcher.service.FileStorageService;

import java.io.IOException;

@Controller
public class FileStorageController {

	private final FileStorageService fileStorageService;

	private final DiplomasService diplomasService;

	private final DiplomaElasticsearchService diplomaElasticsearchService;

	public FileStorageController(FileStorageService fileStorageService,
								 DiplomasService diplomasService,
								 DiplomaElasticsearchService diplomaElasticsearchService) {
		this.fileStorageService = fileStorageService;
		this.diplomasService = diplomasService;
		this.diplomaElasticsearchService = diplomaElasticsearchService;
	}

	@GetMapping("/file/{diplomaId}")
	public ResponseEntity<Resource> getFileByDiplomaId(@PathVariable("diplomaId") Long diplomaId){
		Diploma diploma = diplomasService.findById(diplomaId).orElseThrow(ResourceNotFoundException::new);

		String filename = null;// diploma.getFilename();

		Resource file = fileStorageService.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment;filename=\""+file.getFilename()+"\"")
				.body(file);
	}

	@GetMapping("/file/get/{filename:.+}")
	public ResponseEntity<Resource> getFile(@PathVariable("filename")String filename){
		Resource file = fileStorageService.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment;filename=\""+file.getFilename()+"\"")
				.body(file);
	}


	@PostMapping("/file/{diplomaId}")
	public Diploma upload(
			@PathVariable("diplomaId") Long diplomaId,
			@RequestParam("file") MultipartFile file
	) throws IOException {
		Diploma diploma = diplomasService.findById(diplomaId).orElseThrow(ResourceNotFoundException::new);

		String filename = fileStorageService.save(file);

		// diploma.setFilename(filename);

		diplomasService.saveDiploma(diploma);
		diplomaElasticsearchService.updateDiploma(diploma);
		return diploma;
	}
}
