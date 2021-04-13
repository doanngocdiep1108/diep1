package com.poly.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class HDDTO {
	private String id;
	private Date time;
	private MultipartFile files;
	private boolean type;
	private String email_user;
	public HDDTO() {
		super();
	}
	public HDDTO(String id, Date time, MultipartFile files, boolean type, String email_user) {
		super();
		this.id = id;
		this.time = time;
		this.files = files;
		this.type = type;
		this.email_user = email_user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public MultipartFile getFiles() {
		return files;
	}
	public void setFiles(MultipartFile files) {
		this.files = files;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public String getEmail_user() {
		return email_user;
	}
	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}
	
	
}
