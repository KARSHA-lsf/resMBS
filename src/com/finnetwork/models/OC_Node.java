package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oc_nodes", catalog = "fin_network")
public class OC_Node {

	private int id;
	private String OC_ID;
	private String OC_ENTITY_TYPE;
	private String OC_COMPANY_TYPE;
	private String OC_COMPANY_NUMBER;
	private String OC_CURRENT_STATUS;
	private String OC_OPENCORPORATES_URL;
	private String ENTITY_NAME;
	private String CIK;
	private String JURISDICTION_CODE;
	private String STREET_ADDRESS;
	private String LOCALITY;
	private String REGION;
	private String POSTAL_CODE;
	private String COUNTRY;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "OC_ID")
	public String getOC_ID() {
		return OC_ID;
	}
	public void setOC_ID(String oC_ID) {
		OC_ID = oC_ID;
	}
	@Column(name = "OC_ENTITY_TYPE")
	public String getOC_ENTITY_TYPE() {
		return OC_ENTITY_TYPE;
	}
	public void setOC_ENTITY_TYPE(String oC_ENTITY_TYPE) {
		OC_ENTITY_TYPE = oC_ENTITY_TYPE;
	}
	@Column(name = "OC_COMPANY_TYPE")
	public String getOC_COMPANY_TYPE() {
		return OC_COMPANY_TYPE;
	}
	public void setOC_COMPANY_TYPE(String oC_COMPANY_TYPE) {
		OC_COMPANY_TYPE = oC_COMPANY_TYPE;
	}
	@Column(name = "OC_COMPANY_NUMBER")
	public String getOC_COMPANY_NUMBER() {
		return OC_COMPANY_NUMBER;
	}
	public void setOC_COMPANY_NUMBER(String oC_COMPANY_NUMBER) {
		OC_COMPANY_NUMBER = oC_COMPANY_NUMBER;
	}
	@Column(name = "OC_CURRENT_STATUS")
	public String getOC_CURRENT_STATUS() {
		return OC_CURRENT_STATUS;
	}
	public void setOC_CURRENT_STATUS(String oC_CURRENT_STATUS) {
		OC_CURRENT_STATUS = oC_CURRENT_STATUS;
	}
	@Column(name = "OC_OPENCORPORATES_URL")
	public String getOC_OPENCORPORATES_URL() {
		return OC_OPENCORPORATES_URL;
	}
	public void setOC_OPENCORPORATES_URL(String oC_OPENCORPORATES_URL) {
		OC_OPENCORPORATES_URL = oC_OPENCORPORATES_URL;
	}
	@Column(name = "ENTITY_NAME")
	public String getENTITY_NAME() {
		return ENTITY_NAME;
	}
	public void setENTITY_NAME(String eNTITY_NAME) {
		ENTITY_NAME = eNTITY_NAME;
	}
	@Column(name = "CIK")
	public String getCIK() {
		return CIK;
	}
	public void setCIK(String cIK) {
		CIK = cIK;
	}
	@Column(name = "JURISDICTION_CODE")
	public String getJURISDICTION_CODE() {
		return JURISDICTION_CODE;
	}
	public void setJURISDICTION_CODE(String jURISDICTION_CODE) {
		JURISDICTION_CODE = jURISDICTION_CODE;
	}
	@Column(name = "STREET_ADDRESS")
	public String getSTREET_ADDRESS() {
		return STREET_ADDRESS;
	}
	public void setSTREET_ADDRESS(String sTREET_ADDRESS) {
		STREET_ADDRESS = sTREET_ADDRESS;
	}
	@Column(name = "LOCALITY")
	public String getLOCALITY() {
		return LOCALITY;
	}
	public void setLOCALITY(String lOCALITY) {
		LOCALITY = lOCALITY;
	}
	@Column(name = "REGION")
	public String getREGION() {
		return REGION;
	}
	public void setREGION(String rEGION) {
		REGION = rEGION;
	}
	@Column(name = "POSTAL_CODE")
	public String getPOSTAL_CODE() {
		return POSTAL_CODE;
	}
	public void setPOSTAL_CODE(String pOSTAL_CODE) {
		POSTAL_CODE = pOSTAL_CODE;
	}
	@Column(name = "COUNTRY")
	public String getCOUNTRY() {
		return COUNTRY;
	}
	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}
	
	
	
}
