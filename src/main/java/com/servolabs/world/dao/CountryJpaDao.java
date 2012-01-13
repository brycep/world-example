package com.servolabs.world.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.servolabs.world.domain.Continent;
import com.servolabs.world.domain.Country;

@Service
@SuppressWarnings("unchecked")
public class CountryJpaDao implements CountryDao {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<Country> getCountrysForContinent(Continent continent) {
		return entityManager.createQuery("from Country country where country.continent = :continent")
				.setParameter("continent", continent).getResultList();
	}

	////////////////////////////////
	// Prefetch Optimized version //
	////////////////////////////////
//	@Override
//	public Country find(String countryName)  {
//		return (Country) entityManager.createQuery("select country from Country country left join fetch country.cities where country.name = :countryName")
//				.setParameter("countryName", countryName).getSingleResult();
//	}

	////////////////////////////////
	// Lazy loaded cities version //
	////////////////////////////////
	@Override
	public Country find(String countryName)  {
		return (Country) entityManager.createQuery("from Country country where country.name = :countryName")
				.setParameter("countryName", countryName).getSingleResult();
	}

}
