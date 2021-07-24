package com.taras.vizitkaapi.service;

import java.util.Set;

import org.springframework.stereotype.Service;
import com.taras.vizitkaapi.entity.Interest;
import com.taras.vizitkaapi.repository.InterestRepository;

@Service
public class InterestServiceImpl implements InterestService {
	
	private InterestRepository interestRepository;

	public InterestServiceImpl(InterestRepository interestRepository) {
		this.interestRepository = interestRepository;
	}



	@Override
	public Set<Interest> findByPortfolioId(Long theId) {
		
		return interestRepository.findByPortfoloiId(theId);
	}

}
