package com.nxsol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "cId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cId;

	@Column(name = "cName")
	private String cName;

	@Column(name = "cAdd")
	private String cAdd;

	@Column(name = "cGender")
	private String cGender;

	@Column(name = "cDocument")
	private String cDocument;
	
	@Column(name="cuploadImage")
	private String cuploadImage;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcAdd() {
		return cAdd;
	}

	public void setcAdd(String cAdd) {
		this.cAdd = cAdd;
	}

	public String getcGender() {
		return cGender;
	}

	public void setcGender(String cGender) {
		this.cGender = cGender;
	}

	public String getcDocument() {
		return cDocument;
	}

	public void setcDocument(String cDocument) {
		this.cDocument = cDocument;
	}

	public String getCuploadImage() {
		return cuploadImage;
	}

	public void setCuploadImage(String cuploadImage) {
		this.cuploadImage = cuploadImage;
	}


	
}
