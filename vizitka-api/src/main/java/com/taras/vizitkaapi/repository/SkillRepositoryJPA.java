package com.taras.vizitkaapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taras.vizitkaapi.entity.Portfolio;
import com.taras.vizitkaapi.entity.Skill;

@Repository
public interface SkillRepositoryJPA extends JpaRepository<Skill, Long> {
	Page<Skill> findByPortfolio(Portfolio portfolio, Pageable pageable);
}
