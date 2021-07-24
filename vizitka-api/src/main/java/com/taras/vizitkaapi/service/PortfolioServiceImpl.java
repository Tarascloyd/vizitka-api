package com.taras.vizitkaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taras.vizitkaapi.entity.Portfolio;
import com.taras.vizitkaapi.repository.PortfolioRepositoryJPA;


@Service
public class PortfolioServiceImpl implements PortfolioService {

	
	private PortfolioRepositoryJPA portfolioRepository;
	
	
	
	public PortfolioServiceImpl(PortfolioRepositoryJPA portfolioRepository) {
		this.portfolioRepository = portfolioRepository;
	}

	@Override
	@Transactional
	public List<Portfolio> findAll() {
		
		return portfolioRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Portfolio> findById(Long theId) {
		
		return portfolioRepository.findById(theId);
	}

	@Override
	@Transactional
	public void save(Portfolio theUser) {
		portfolioRepository.save(theUser);
	}

}
