package com.poly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BDSImage")
public class BDSImage implements Serializable{

	@Id
	private int id;
	@Column(length = 255)
	private String image;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bds_id")
	private BDS bds;
	
	public BDSImage() {
		super();
	}

	public BDSImage(int id, String image, BDS bds) {
		super();
		this.id = id;
		this.image = image;
		this.bds = bds;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public BDS getBds() {
		return bds;
	}

	public void setBds(BDS bds) {
		this.bds = bds;
	}
		
}
