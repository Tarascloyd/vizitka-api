package com.taras.vizitkaapi.service;

import java.util.Set;

import com.taras.vizitkaapi.entity.Interest;

public interface InterestService {
	public Set<Interest> findByPortfolioId(Long theId);
}
