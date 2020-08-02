package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oc_edges", catalog = "fin_network")
public class OC_Link {

	private int id;
	private String OC_SUBJECT_ID;
	private String OC_PREDICATE_TYPE;
	private String OC_OBJECT_ID;
	private String OC_CONFIDENCE_SCORE;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "OC_SUBJECT_ID")
	public String getOC_SUBJECT_ID() {
		return OC_SUBJECT_ID;
	}
	public void setOC_SUBJECT_ID(String oC_SUBJECT_ID) {
		OC_SUBJECT_ID = oC_SUBJECT_ID;
	}
	@Column(name = "OC_PREDICATE_TYPE")
	public String getOC_PREDICATE_TYPE() {
		return OC_PREDICATE_TYPE;
	}
	public void setOC_PREDICATE_TYPE(String oC_PREDICATE_TYPE) {
		OC_PREDICATE_TYPE = oC_PREDICATE_TYPE;
	}
	@Column(name = "OC_OBJECT_ID")
	public String getOC_OBJECT_ID() {
		return OC_OBJECT_ID;
	}
	public void setOC_OBJECT_ID(String oC_OBJECT_ID) {
		OC_OBJECT_ID = oC_OBJECT_ID;
	}
	@Column(name = "OC_CONFIDENCE_SCORE")
	public String getOC_CONFIDENCE_SCORE() {
		return OC_CONFIDENCE_SCORE;
	}
	public void setOC_CONFIDENCE_SCORE(String oC_CONFIDENCE_SCORE) {
		OC_CONFIDENCE_SCORE = oC_CONFIDENCE_SCORE;
	}
	
	
}
