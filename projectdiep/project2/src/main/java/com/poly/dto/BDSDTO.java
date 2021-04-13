package com.poly.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class BDSDTO {
	private String id;
	private String name;
	private String address;
	private String district;
	private String city;
	private Float price;
	private int s;
	private String people;
//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date time;
	private String phone;
	private String note;
	private String type;
	private MultipartFile image;
	public BDSDTO() {
		super();
	}
	public BDSDTO(String id, String name, String address, String district, String city, Float price, int s,
			String people, Date time, String phone, String note, String type, MultipartFile image) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.district = district;
		this.city = city;
		this.price = price;
		this.s = s;
		this.people = people;
		this.time = time;
		this.phone = phone;
		this.note = note;
		this.type = type;
		this.image = image;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getS() {
		return s;
	}
	public void setS(int s) {
		this.s = s;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
}
