package com.poly.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin implements Serializable{
	@Id
	@Column(length = 5)
	private String id;
	@Column(length = 50)
	private String password;
	@Column(length = 100)
	private String fullname;
//	@Temporal(TemporalType .DATE)
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
	private boolean gender;
	@Column(length = 10)
	private String phone;
	@Column(length = 100)
	private String role;
	
	
	public Admin() {
		super();
	}
	
	public Admin(String id) {
		super();
		this.id = id;
	}
	public Admin(String id, String password, String fullname, Date birthday, boolean gender, String phone,
			String role) {
		super();
		this.id = id;
		this.password = password;
		this.fullname = fullname;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
