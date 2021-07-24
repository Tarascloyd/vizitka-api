package com.taras.vizitkaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taras.vizitkaapi.entity.Portfolio;

@Repository
public interface PortfolioRepositoryJPA extends JpaRepository<Portfolio, Long> {

}
