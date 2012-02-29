package com.servolabs.world.dao;

import java.util.List;

import com.servolabs.world.domain.Country;
import com.servolabs.world.domain.CountryLanguage;

public interface CountryDao {
	
	List<Country> getCountriesForContinent(String contenentName);
	Country find(String name);
	List<Country> findCountriesInRegion(String regionName);
	List<CountryLanguage> findLanguagesUsingNativeQuery(String countryCode);
}
