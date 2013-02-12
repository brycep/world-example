package com.servolabs.world.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.servolabs.world.domain.Continent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-business-context.xml")
@Transactional
public class ContinentDaoImplTest {
	
	@Autowired
	private ContinentDaoImpl continentDao;
	
	@Test
	public void findAllContinents()  {
		List<Continent> allContinents = continentDao.findAll();
		assertNotNull(allContinents);
		assertFalse(allContinents.isEmpty());
		System.out.println("Found " + allContinents.size() + " continents.");

        // Let's try finding our contents again
		continentDao.findAll();
		
	}
	
}
