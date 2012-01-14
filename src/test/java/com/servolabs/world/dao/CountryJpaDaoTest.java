package com.servolabs.world.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.servolabs.world.domain.City;
import com.servolabs.world.domain.Country;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-business-context.xml")
@Transactional
public class CountryJpaDaoTest {
	
	private static final Logger logger = Logger.getLogger(CountryJpaDaoTest.class.getName()); 
	
	@Autowired
	private CountryJpaDao countryDao;
	
	// This test will demonstrate how you can change your query to force eager loading
	// of data to occur.
	@Test
	public void findAllCitiesInUS()  {
		Country country = (Country) countryDao.find("United States");
		Set<City> cityList = country.getCities();
		logger.info("First City found: " + cityList.iterator().next().getName());
		for(City city : cityList)  {
			assertNotNull(city.getName());
		}
	}
	
	@Test
	public void findAllCountriesInContinentLoadsTheCorrectContinent()  {
		List<Country> countryList = countryDao.getCountriesForContinent("North America");
		for(Country country : countryList)  {
			assertEquals("North America", country.getContinent().getName().trim());
		}
	}

}
