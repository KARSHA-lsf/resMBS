package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_edges", catalog = "fin_network")
public class APP_Link {

	private int id;
	private String CIK_1;
	private String CIK_2;
	private int hasTnic;
	
	public APP_Link() {
		
	}
	
	public APP_Link(int id, String CIK_1, String CIK_2) {
		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CIK_1")
	public String getCIK_1() {
		return CIK_1;
	}

	public void setCIK_1(String CIK_1) {
		this.CIK_1 = CIK_1;
	}

	@Column(name = "CIK_2")
	public String getCIK_2() {
		return CIK_2;
	}

	public void setCIK_2(String CIK_2) {
		this.CIK_2 = CIK_2;
	}
	
	@Column(name = "hasTnic")
	public int getHasTnic() {
		return hasTnic;
	}

	public void setHasTnic(int hasTnic) {
		this.hasTnic = hasTnic;
	}
	
}
