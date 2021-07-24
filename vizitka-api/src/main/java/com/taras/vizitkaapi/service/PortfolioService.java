package com.taras.vizitkaapi.service;

import java.util.List;
import java.util.Optional;

import com.taras.vizitkaapi.entity.Portfolio;


public interface PortfolioService {
	
	public List<Portfolio> findAll();
	
	public Optional<Portfolio> findById(long theId);
	
	public void  save(Portfolio theUser);
}
