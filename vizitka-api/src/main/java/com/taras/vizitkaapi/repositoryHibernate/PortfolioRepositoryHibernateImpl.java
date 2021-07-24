package com.taras.vizitkaapi.repositoryHibernate;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.taras.vizitkaapi.entity.Portfolio;

@Repository
public class PortfolioRepositoryHibernateImpl implements PortfolioRepository {

	private EntityManager entityManager;
	
	public PortfolioRepositoryHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Portfolio> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Portfolio> theQuery = currentSession.createQuery("from Portfolio", Portfolio.class);
		
		return theQuery.getResultList();
	}

	@Override
	public Optional<Portfolio> findById(Long theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		return currentSession.byId(Portfolio.class).loadOptional( theId );
	}

	@Override
	public void save(Portfolio theUser) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theUser);
	}
	
}
