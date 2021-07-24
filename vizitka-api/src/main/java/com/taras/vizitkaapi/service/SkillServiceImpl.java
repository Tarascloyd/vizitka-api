package com.taras.vizitkaapi.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taras.vizitkaapi.entity.Portfolio;
import com.taras.vizitkaapi.entity.Skill;
import com.taras.vizitkaapi.repository.PortfolioRepositoryJPA;
import com.taras.vizitkaapi.repository.SkillRepositoryJPA;

@Service
public class SkillServiceImpl implements SkillService {

	private SkillRepositoryJPA skillRepository;
	private PortfolioRepositoryJPA portfolioRepository;
	
	

	public SkillServiceImpl(SkillRepositoryJPA skillRepository, PortfolioRepositoryJPA portfolioRepository) {
		this.skillRepository = skillRepository;
		this.portfolioRepository = portfolioRepository;
	}

	@Override
	@Transactional
	public Set<Skill> findAll() {
		
		return new HashSet<Skill>(skillRepository.findAll());
	}

	@Override
	@Transactional
	public Optional<Skill> findById(Long theId) {
		
		return skillRepository.findById(theId);
	}

	@Override
	@Transactional
	public void save(Skill theSkill) {
		
		skillRepository.save(theSkill);
	}

	@Override
	public Set<Skill> findByPortfolioId(Long theId) {
		Optional<Portfolio> portfolio = portfolioRepository.findById(theId);
		if (!portfolio.isPresent()) {
			return new HashSet<Skill>();
		}
		
		return skillRepository.findByPortfolio(portfolio.get());
	}

}
