package com.taras.vizitkaapi.repository;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.taras.vizitkaapi.entity.Interest;

@Repository
public class InterestRepositoryHibernateImpl implements InterestRepository {
	
	private EntityManager entityManager;
	
	public InterestRepositoryHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Set<Interest> findByPortfoloiId(Long theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Interest> theQuery = currentSession.createNativeQuery(
				"SELECT * " +
				"FROM interests " +
				"WHERE portfolio_id = :id"
				, Interest.class).setParameter("id", theId);
		return theQuery.getResultStream().collect(Collectors.toSet());
	}

}
