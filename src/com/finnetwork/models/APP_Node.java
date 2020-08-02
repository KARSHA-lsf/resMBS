package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_nodes", catalog = "fin_network")
public class APP_Node {
	
	private int id;
	private String name;
	private String cik;
	
	public APP_Node() {
	
	}
	
	public APP_Node(int id, String name,String cik) {
		this.id = id;
		this.name = name;
		this.cik = cik;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "cik")
	public String getcik() {
		return cik;
	}

	public void setcik(String cik) {
		this.cik = cik;
	}
}
