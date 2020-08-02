package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sector51_companies", catalog = "fin_network")
public class Sector51_comp {
	private int id;
	private int CIK;
	private String ticker_symbol;
	private String name;
	private int naics;
	private int GVKEY;
	private String trdf_id;

	public Sector51_comp() {
		
	}
	
	public Sector51_comp(Integer id, Integer CIK , String ticker_symbol, String name, Integer naics,Integer GVKEY) {
		this.id = id;
		this.CIK = CIK;
		this.ticker_symbol = ticker_symbol;
		this.name = name;
		this.naics = naics;
		this.GVKEY = GVKEY;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "CIK")
	public int getCIK() {
		return CIK;
	}

	public void setCIK(int cIK) {
		CIK = cIK;
	}

	@Column(name = "ticker_symbol")
	public String getTicker_symbol() {
		return ticker_symbol;
	}

	public void setTicker_symbol(String ticker_symbol) {
		this.ticker_symbol = ticker_symbol;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "naics")
	public int getNaics() {
		return naics;
	}

	public void setNaics(int naics) {
		this.naics = naics;
	}
	@Column(name = "GVKEY")
	public int getGVKEY() {
		return GVKEY;
	}

	public void setGVKEY(int gVKEY) {
		GVKEY = gVKEY;
	}
	@Column(name = "trdf_id")
	public String getTrdf_id() {
		return trdf_id;
	}

	public void setTrdf_id(String trdf_id) {
		this.trdf_id = trdf_id;
	}

	
}
