package com.online.util;

import com.online.response.PhotoResponse;

public class PhotoResponseBuilder {

	public static PhotoResponse buildPhotoResponse(String id)
	{
		PhotoResponse response = new PhotoResponse();
		response.setCode("200");
		response.setPhotoId(id);
		response.setMessage("Photo added successfully");
		return response;
	}
	
	public static PhotoResponse buildPhotoRetrievedResponse(String id)
	{
		PhotoResponse response = new PhotoResponse();
		response.setCode("200");
		response.setPhotoId(id);
		response.setMessage("Photo retrieved successfully");
		return response;
	}
	
}
