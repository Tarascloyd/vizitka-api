package com.taras.vizitkaapi.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taras.vizitkaapi.entity.Interest;
import com.taras.vizitkaapi.entity.Portfolio;

@Repository
public interface InterestRepositoryJPA extends JpaRepository<Interest, Long> {
	Set<Interest> findByPortfolio(Portfolio portfolio);
}
