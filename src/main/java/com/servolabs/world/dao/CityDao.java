package com.servolabs.world.dao;

import java.util.List;

import com.servolabs.world.domain.City;

public interface CityDao {

	List<City> findAllCities(int pageNumber, int resultsPerPage);
}
