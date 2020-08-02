package com.finnetwork.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "topic_mdl_sankey_pi", catalog = "fin_network")
public class Topic_mdl__sankey {
	@Id
	private String FI_Name;
	private String FI;
	private int Year;
	private float nominal_value_million;
	private String associated_topic;
	
	
	public String getFI_Name() {
		return FI_Name;
	}
	public void setFI_Name(String fI_Name) {
		FI_Name = fI_Name;
	}
	public String getFI() {
		return FI;
	}
	public void setFI(String fI) {
		FI = fI;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public float getNominal_value_million() {
		return nominal_value_million;
	}
	public void setNominal_value_million(float nominal_value_million) {
		this.nominal_value_million = nominal_value_million;
	}
	public String getAssociated_topic() {
		return associated_topic;
	}
	public void setAssociated_topic(String associated_topic) {
		this.associated_topic = associated_topic;
	}
	
	
	
	
}
