package com.finnetwork.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topic_mdl_prospectus_v2_f", catalog = "fin_network")
public class prospectusv3 {
	@Id
	private String Total;
	private String A;
	private String B;
	private String M;
	private String PID;
	private String year;
	private String Prospectus;
	private String nominal_value_million;
	private String associated_topic;
	
	
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
	public String getTotal() {
		return Total;
	}
	public void setTotal(String total) {
		Total = total;
	}
	public String getA() {
		return A;
	}
	public void setA(String a) {
		A = a;
	}
	public String getB() {
		return B;
	}
	public void setB(String b) {
		B = b;
	}
	public String getM() {
		return M;
	}
	public void setM(String m) {
		M = m;
	}
	
}
