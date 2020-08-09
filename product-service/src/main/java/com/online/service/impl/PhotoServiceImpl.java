package com.online.service.impl;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.online.exception.model.PhotoException;
import com.online.model.CarPhoto;
import com.online.repository.PhotoRepository;
import com.online.service.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoRepository photoRepo;

	public String addPhoto(String carId, String title, MultipartFile file) {
		CarPhoto photo = new CarPhoto(title);
		try {
			photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		} catch (IOException e) {
			throw new PhotoException(e.getMessage());
		}
		photo = photoRepo.insert(photo);
		return photo.getId();
	}

	public CarPhoto getPhoto(String id) {
		return photoRepo.findById(id).get();
	}

}
