package com.taras.vizitkaapi.service;

import java.util.Optional;
import java.util.Set;

import com.taras.vizitkaapi.entity.Skill;

public interface SkillService {
	public Set<Skill> findAll();
	
	public Optional<Skill> findById(Long theId);
	
	public void  save(Skill theSkill);

	public Set<Skill> findByPortfolioId(Long theId);
}
