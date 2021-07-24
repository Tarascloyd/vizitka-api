package com.taras.vizitkaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public List<Skill> findAll() {
		
		return skillRepository.findAll();
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
	@Transactional
	public Page<Skill> findByPortfolioId(Long theId, Pageable pageable) {
		Optional<Portfolio> portfolio = portfolioRepository.findById(theId);
		if (!portfolio.isPresent()) {
			return Page.empty();
		}

	    Page<Skill> skills = skillRepository.findByPortfolio(portfolio.get(), pageable);
	    return skills;
	}

}
