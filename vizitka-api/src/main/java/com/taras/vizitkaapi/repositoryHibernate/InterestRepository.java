package com.taras.vizitkaapi.repositoryHibernate;

import java.util.Set;

import com.taras.vizitkaapi.entity.Interest;

public interface InterestRepository {
	public Set<Interest> findByPortfolioId(Long theId);
}
