package com.poly.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BDS")
public class BDS implements Serializable{

	@Id
	@Column(length = 5)
	private String id;
	@Column(length = 100)
	private String name;
	@Column(length = 100)
	private String address;
	@Column(length = 100)
	private String district;
	@Column(length = 100)
	private String city;
	private Float price;
	private int s;
	@Column(length = 100)
	private String people;
//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date time;
	@Column(length = 10)
	private String phone;
	@Column(length = 1000)
	private String note;
	@Column(length = 100)
	private String type;
	@Column(length = 255)
	private String image;
		
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "bds")
	private Set<BDSImage> img;
	
	
	public Set<BDSImage> getImg() {
		return img;
	}

	public void setImg(Set<BDSImage> img) {
		this.img = img;
	}

	public BDS() {
		super();
	}
	
	public BDS(String id) {
		super();
		this.id = id;
	}

	public BDS(String id, String name, String address, String district, String city, Float price, int s, String people,
			Date time, String phone, String note, String type, String image) {
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

	public BDS(String id, String name, String address, String district, String city, Float price, int s, String people,
			Date time, String phone, String note, String type, String image, Set<BDSImage> img) {
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
		this.img = img;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	
}
