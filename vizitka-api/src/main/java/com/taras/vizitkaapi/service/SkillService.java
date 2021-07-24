package com.taras.vizitkaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.taras.vizitkaapi.entity.Skill;

public interface SkillService {
	public List<Skill> findAll();
	
	public Optional<Skill> findById(Long theId);
	
	public void  save(Skill theSkill);

	public Page<Skill> findByPortfolioId(Long theId, Pageable pageable);
}
