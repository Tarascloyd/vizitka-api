package com.taras.vizitkaapi.repository;

import java.util.Set;

import com.taras.vizitkaapi.entity.Interest;

public interface InterestRepository {
	public Set<Interest> findByPortfoloiId(Long theId);
}
