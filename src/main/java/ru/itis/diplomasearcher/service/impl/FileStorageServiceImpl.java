package ru.itis.diplomasearcher.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.diplomasearcher.service.FileStorageService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageServiceImpl implements FileStorageService {

	private final String uploadDirPathString;
	private final Path uploadDirPath;

	public FileStorageServiceImpl(@Value("${files.upload.path}") String uploadDirPathString){
		this.uploadDirPathString = uploadDirPathString;
		this.uploadDirPath = Paths.get(uploadDirPathString);
	}

	@Override
	public String save(MultipartFile file) throws IOException {
		if (file != null && !file.getOriginalFilename().isEmpty()) {

			File uploadDir = new File(uploadDirPathString);

			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			String uuidFile = UUID.randomUUID().toString();
			String resultFilename = uuidFile + "_" + file.getOriginalFilename();

			file.transferTo(new File(uploadDirPathString + "/" + resultFilename));
			return resultFilename;
		}
		return null;
	}

	@Override
	public Resource load(String filename) {
		Path file = uploadDirPath.resolve(filename);
		try {
			Resource resource = new UrlResource(file.toUri());
			if(resource.exists() || resource.isReadable()){
				return resource;
			}else{
				throw new RuntimeException("Could not read the file.");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error:"+e.getMessage());
		}
	}
}
