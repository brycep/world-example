package com.servolabs.world.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.servolabs.world.domain.City;

@Repository
@SuppressWarnings("unchecked")
public class CityDaoImpl implements CityDao {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<City> findAllCities(int fromIndex, int toIndex) {
		Query query = entityManager.createQuery("select c from City c");
		return (List<City>)query.getResultList().subList(fromIndex, toIndex);
	}
	
	
	
	

}
