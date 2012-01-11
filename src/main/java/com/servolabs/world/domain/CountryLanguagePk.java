package com.servolabs.world.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CountryLanguagePk implements Serializable {
	
	private static final long serialVersionUID = 5813108025954889385L;
	private String countryCode;
	private String language;
	
	public CountryLanguagePk() {}
	
	public CountryLanguagePk(String countryCode, String language)  {
		this.countryCode = countryCode;
		this.language = language;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryLanguagePk other = (CountryLanguagePk) obj;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		return true;
	}

}
