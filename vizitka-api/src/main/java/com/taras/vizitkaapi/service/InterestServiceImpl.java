package com.taras.vizitkaapi.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import com.taras.vizitkaapi.entity.Interest;
import com.taras.vizitkaapi.entity.Portfolio;
import com.taras.vizitkaapi.repository.InterestRepositoryJPA;
import com.taras.vizitkaapi.repository.PortfolioRepositoryJPA;

@Service
public class InterestServiceImpl implements InterestService {
	
	private InterestRepositoryJPA interestRepository;
	private PortfolioRepositoryJPA portfolioRepository;

	public InterestServiceImpl(InterestRepositoryJPA interestRepository, PortfolioRepositoryJPA portfolioRepository) {
		this.interestRepository = interestRepository;
		this.portfolioRepository = portfolioRepository;
	}

	@Override
	public Set<Interest> findByPortfolioId(Long theId) {
		Optional<Portfolio> portfolio = portfolioRepository.findById(theId);
		if (!portfolio.isPresent()) {
			return new HashSet<Interest>();
		}
		
		return interestRepository.findByPortfolio(portfolio.get());
		
	}

}
