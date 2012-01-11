package com.servolabs.world.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.servolabs.world.domain.Continent;
import com.servolabs.world.domain.Country;

@Service
public class CountryJpaDao implements CountryDao {

//    @Autowired
//    private EntityManager entityManager;

	@Override
	public List<Country> getCountrysForContinent(Continent contenent) {
		return null;
	}
	
	

}
