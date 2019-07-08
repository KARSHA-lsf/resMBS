package com.finnetwork.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topic_mdl_issuers", catalog = "fin_network")
public class topic_mdl_issuers {
	@Id
	private int id;
	private String Fc;
	private String Fi;
	private String Role;
	private String Prospectus_name;
	private String Fi_name;
	private int year;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFc() {
		return Fc;
	}
	public void setFc(String fc) {
		Fc = fc;
	}
	public String getFi() {
		return Fi;
	}
	public void setFi(String fi) {
		Fi = fi;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getProspectus_name() {
		return Prospectus_name;
	}
	public void setProspectus_name(String prospectus_name) {
		Prospectus_name = prospectus_name;
	}
	public String getFi_name() {
		return Fi_name;
	}
	public void setFi_name(String fi_name) {
		Fi_name = fi_name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "issuers [id=" + id + ", Fc=" + Fc + ", Fi=" + Fi + ", Role=" + Role + ", Prospectus_name="
				+ Prospectus_name + ", Fi_name=" + Fi_name + ", year=" + year + "]";
	}

}
