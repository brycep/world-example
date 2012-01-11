package com.servolabs.world.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.servolabs.world.domain.Continent;
import com.servolabs.world.domain.Country;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-business-context.xml")
@Transactional
public class CountryJpaDaoTest {
	
	private static final Logger logger = Logger.getLogger(CountryJpaDaoTest.class.getName()); 
	
	@Autowired
	private CountryJpaDao countryDao;
    @PersistenceContext
    private EntityManager entityManager;
	
	@Test
	public void findAllNorthAmericanCountries()  {
		
		Continent northAmerica = 
				(Continent) entityManager.createQuery("from Continent where name = 'North America'")
				.getSingleResult();
		
		List<Country> countries = countryDao.getCountrysForContinent(northAmerica);
		assertNotNull(countries);
		assertFalse(countries.isEmpty());
		
		logger.info("Successfully retrieved " + countries.size() + " countries.");
	}

}
