package com.poly.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Users")
public class Users implements Serializable{

	@Id
	@Column(length = 100)
	private String email;
	@Column(length = 50)
	private String password;
	@Column(length = 100)
	private String fullname;
//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
	private boolean gender;
	@Column(length = 10)
	private String phone;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "users")
	private Set<QLHopDong> hd;
	
	public Set<QLHopDong> getHd() {
		return hd;
	}
	public void setHd(Set<QLHopDong> hd) {
		this.hd = hd;
	}
	public Users() {
		super();
	}
	
	public Users(String email) {
		super();
		this.email = email;
	}
	public Users(String email, String password, String fullname, Date birthday, boolean gender, String phone) {
		super();
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
}
