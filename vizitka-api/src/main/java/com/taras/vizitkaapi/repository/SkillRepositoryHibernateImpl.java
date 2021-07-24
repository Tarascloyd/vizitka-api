package com.taras.vizitkaapi.repository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.taras.vizitkaapi.entity.Skill;

@Repository
public class SkillRepositoryHibernateImpl implements SkillRepository {

	private EntityManager entityManager;
	
	public SkillRepositoryHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Set<Skill> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Skill> theQuery = currentSession.createQuery("from Skill", Skill.class);
		
		return theQuery.getResultStream().collect(Collectors.toSet());
	}

	@Override
	public Optional<Skill> findById(Long theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		return currentSession.byId(Skill.class).loadOptional(theId);
	}

	@Override
	public void save(Skill theSkill) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theSkill);
	}

	@Override
	public Set<Skill> findByPortfoloiId(Long theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Skill> theQuery = currentSession.createNativeQuery(
				"SELECT * " +
				"FROM skills " +
				"WHERE portfolio_id = :id"
				, Skill.class).setParameter("id", theId);
		return theQuery.getResultStream().collect(Collectors.toSet());
	}

}
