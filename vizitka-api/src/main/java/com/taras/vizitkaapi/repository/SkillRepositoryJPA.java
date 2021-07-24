package com.taras.vizitkaapi.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taras.vizitkaapi.entity.Portfolio;
import com.taras.vizitkaapi.entity.Skill;

@Repository
public interface SkillRepositoryJPA extends JpaRepository<Skill, Long> {
	Set<Skill> findByPortfolio(Portfolio portfolio);
}
