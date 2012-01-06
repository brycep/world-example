package com.servolabs.world.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRYLANGUAGE")
public class CountryLanguage {

	@Id
	private String countryCode;
	
	@Id
	private String language;
	
	// TODO:  Turn this into a boolean
	@Column
	private String isOfficial;
	
	@Column
	private Double percentage;
	
	public CountryLanguage()  {
		
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(String isOfficial) {
		this.isOfficial = isOfficial;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	
	
}
