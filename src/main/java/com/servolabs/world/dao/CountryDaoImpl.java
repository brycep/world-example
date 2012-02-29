package com.servolabs.world.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.servolabs.world.domain.Country;
import com.servolabs.world.domain.CountryLanguage;

@Repository
@SuppressWarnings("unchecked")
public class CountryDaoImpl implements CountryDao {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<Country> getCountriesForContinent(String continentName) {
		return entityManager.createQuery("from Country country where country.continent.name = :continentName")
				.setParameter("continentName", continentName).getResultList();
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

	@Override
	public List<Country> findCountriesInRegion(String regionName) {
		Query query = entityManager.createQuery("from Country country where country.region = :regionName")
				.setParameter("regionName", regionName);
		 // If you're using the Hibernate API directly, use setCachable(true) and setCacheRegion("countryQueryCache")
		 // calls
		query.setHint("org.hibernate.cacheable", true);
		query.setHint("org.hibernate.cacheRegion", "countryQueryCache");
		return query.getResultList();
	}
	
	@Override
	public List<CountryLanguage> findLanguagesUsingNativeQuery(String countryCode)  {
		Query query = entityManager
				.createNamedQuery("findLanguagesForCountry")
				.setParameter("countryCode", countryCode);
		return (List<CountryLanguage>)query.getResultList();
	}

}
