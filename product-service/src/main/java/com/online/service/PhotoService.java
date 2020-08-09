package com.online.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.online.model.CarPhoto;

public interface PhotoService {

	public String addPhoto(String carId,String title, MultipartFile file);
	
	public CarPhoto getPhoto(String id);
}
