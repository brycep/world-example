package com.servolabs.world.dao;

import java.util.List;

import com.servolabs.world.domain.Country;

public interface CountryDao {
	
	List<Country> getCountriesForContinent(String contenentName);
	Country find(String name);
	List<Country> findCountriesInRegion(String regionName);

}
