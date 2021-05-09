package ru.itis.diplomasearcher.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {
	/**
	*@return returns filename of saved file
	*/
	String save(MultipartFile multipartFile) throws IOException;

	Resource load(String filename);
}
