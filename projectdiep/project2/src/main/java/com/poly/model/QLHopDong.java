package com.poly.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="QLHopDong")
public class QLHopDong implements Serializable{

	@Id
	@Column(length = 5)
	private String id;
//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date time;
	@Column(length = 100)
	private String files;
	private boolean type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email_user")
	private Users users;

	public QLHopDong() {
		super();
	}

	
	public QLHopDong(String id, Date time, String files, boolean type, Users users) {
		super();
		this.id = id;
		this.time = time;
		this.files = files;
		this.type = type;
		this.users = users;
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

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}


	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}

	

}
