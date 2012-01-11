package com.servolabs.world.dao;

import java.util.List;

import com.servolabs.world.domain.Continent;
import com.servolabs.world.domain.Country;

public interface CountryDao {
	
	List<Country> getCountrysForContinent(Continent contenent);

}
