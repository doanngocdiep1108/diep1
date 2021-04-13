package com.poly.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImageDTO {
	
	private int id;
	private MultipartFile image;
	private String bds_id;
	public ImageDTO() {
		super();
	}
	public ImageDTO(int id, MultipartFile image, String bds_id) {
		super();
		this.id = id;
		this.image = image;
		this.bds_id = bds_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getBds_id() {
		return bds_id;
	}
	public void setBds_id(String bds_id) {
		this.bds_id = bds_id;
	}
	
}
