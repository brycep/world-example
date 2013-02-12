package com.servolabs.world.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.servolabs.world.domain.City;
import com.servolabs.world.domain.Country;
import com.servolabs.world.domain.CountryLanguage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-business-context.xml")
@Transactional
public class CountryDaoImplTest {
	
	private static final Logger log = Logger.getLogger(CountryDaoImplTest.class.getName()); 
	
	@Autowired
	private CountryDaoImpl countryDao;
	@PersistenceContext 
	private EntityManager entityManager;
	
	//  Query Optimization Example --  Eager Fetching
	// This test will demonstrate how you can change your query to force eager loading
	// of data to occur.
	@Test
	public void findAllCitiesInUS()  {
		Country country = (Country) countryDao.find("United States");
		Set<City> cityList = country.getCities();
		log.info("First City found: " + cityList.iterator().next().getName());
		for(City city : cityList)  {
			assertNotNull(city.getName());
		}
	}
	
	//////////////////////////////
	//  Native Query Examples   //
	//////////////////////////////
	@Test
	public void findLanguages()  {
		String countryCode = "CAN";
		Collection<CountryLanguage> languages = countryDao.findLanguagesUsingNativeQuery(countryCode);

		assertEquals(12, languages.size());
	}
	
	///////////////////////
	//  Cache Examples   //
	///////////////////////
	@Test
	public void findAllCountriesInContinentLoadsTheCorrectContinent()  {

        //  For this test, make sure to run the entire test suite, then look at how
        // many times we queried for Continents.

		List<Country> countryList = countryDao.getCountriesForContinent("North America");
		for(Country country : countryList)  {
			assertEquals("North America", country.getContinent().getName().trim());
		}
		
		Statistics stats = getStatistics();

		double cacheHitCount = stats.getSecondLevelCacheHitCount();
		double cacheMissCount = stats.getSecondLevelCacheMissCount();
		double cacheHitRatio =
		  cacheHitCount / (cacheHitCount + cacheMissCount);

		log.info("Cache hit count: " + cacheHitCount);
		log.info("Cache miss count: " + cacheMissCount);
		log.info("Query Hit ratio:" + cacheHitRatio);

	}
	
	@Test
	public void findCountriesForRegion_QueryCacheTest()  {
		String region = "Western Africa";
		List<Country> countryList = countryDao.findCountriesInRegion(region);
		
		assertNotNull(countryList);
		assertTrue(0 != countryList.size());
		System.out.println("Found " + countryList.size() + " objects");
		
		countryList = countryDao.findCountriesInRegion(region);
		System.out.println("Found " + countryList.size() + " objects");
		
		countryDao.findCountriesInRegion(region);
	}
	
	private Statistics getStatistics() {
		return ((Session)entityManager.getDelegate()).getSession(EntityMode.POJO).getSessionFactory().getStatistics();
    }

}
