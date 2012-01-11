package com.servolabs.world.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.servolabs.world.domain.Continent;

@Service("ContinentDao")
@SuppressWarnings("unchecked")
public class ContinentJpaDao implements ContinentDao {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<Continent> findAll() {
		Query query = entityManager.createQuery("select c from Continent c");
		return (List<Continent>)query.getResultList();
	}
	
}
