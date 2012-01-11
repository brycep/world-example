package com.servolabs.world.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="countrylanguage", schema="public")
public class CountryLanguage {

	@EmbeddedId
	private CountryLanguagePk pk;
	
	// TODO:  Turn this into a boolean
	@Column
	private String isOfficial;
	
	@Column
	private Double percentage;
	
	public CountryLanguage()  {
		
	}

	public CountryLanguagePk getPk() {
		return pk;
	}

	public void setPk(CountryLanguagePk pk) {
		this.pk = pk;
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
