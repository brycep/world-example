package com.servolabs.world.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@NamedNativeQuery(name="findLanguagesForCountry",
		query="select CountryCode, Language, IsOfficial, Percentage from CountryLanguage where CountryCode = :countryCode",
		resultSetMapping="languageMapping")
@SqlResultSetMapping(name="languageMapping",
		entities={
			@EntityResult(entityClass=CountryLanguage.class, fields= {
				@FieldResult(name="pk.countryCode", column="CountryCode"),
				@FieldResult(name="pk.language", column="Language"),
				@FieldResult(name="isOfficial", column="IsOfficial"),
				@FieldResult(name="percentage", column="Percentage")
			})
})
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
