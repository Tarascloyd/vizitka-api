package com.taras.vizitkaapi.repository;

import java.util.List;
import java.util.Optional;

import com.taras.vizitkaapi.entity.Portfolio;

public interface PortfolioRepository {
	public List<Portfolio> findAll();
	
	public Optional<Portfolio> findById(long theId);
	
	public void save(Portfolio theUser);
}
