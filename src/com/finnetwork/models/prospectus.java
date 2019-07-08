package com.finnetwork.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topic_mdl_prospectus", catalog = "fin_network")
public class prospectus {
	@Id
	private String n;
	private String n_a;
	private String n_b;
	private String n_m;
	private String PID;
	private String year;
	private String Prospectus;
	private String nominal_value_million;
	private String associated_topic;
	
	public String getN_a() {
		return n_a;
	}
	public void setN_a(String n_a) {
		this.n_a = n_a;
	}
	public String getN_b() {
		return n_b;
	}
	public void setN_b(String n_b) {
		this.n_b = n_b;
	}
	public String getN_m() {
		return n_m;
	}
	public void setN_m(String n_m) {
		this.n_m = n_m;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public String getPID() {
		return PID;
	}
	public void setPID(String pID) {
		PID = pID;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getProspectus() {
		return Prospectus;
	}
	public void setProspectus(String prospectus) {
		Prospectus = prospectus;
	}
	public String getNominal_value_million() {
		return nominal_value_million;
	}
	public void setNominal_value_million(String nominal_value_million) {
		this.nominal_value_million = nominal_value_million;
	}
	public String getAssociated_topic() {
		return associated_topic;
	}
	public void setAssociated_topic(String associated_topic) {
		this.associated_topic = associated_topic;
	}
	
}
