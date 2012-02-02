package com.servolabs.world.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.servolabs.world.domain.City;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-business-context.xml")
@Transactional
public class CityDaoImplTest {

	@Autowired
	private CityDaoImpl cityDao;
	
	@Test
	public void retrievePagedCityList()  {
		
		// Retrieve data for Page 1
		List<City> page1 = cityDao.findAllCities(0, 50);
		assertEquals(50, page1.size());
		
		List<City> page2 = cityDao.findAllCities(50, 100);
		assertEquals(50, page2.size());
		
	}

}
