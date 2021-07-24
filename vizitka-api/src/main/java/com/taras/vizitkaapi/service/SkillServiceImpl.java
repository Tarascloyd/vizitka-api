package com.taras.vizitkaapi.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taras.vizitkaapi.entity.Skill;
import com.taras.vizitkaapi.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {

	private SkillRepository skillRepository;
	
	public SkillServiceImpl(SkillRepository skillRepository) {
		this.skillRepository = skillRepository;
	}

	@Override
	@Transactional
	public Set<Skill> findAll() {
		
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
	public Set<Skill> findByPortfolioId(Long theId) {
		
		return skillRepository.findByPortfoloiId(theId);
	}

}
