package com.taras.vizitkaapi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.taras.vizitkaapi.entity.Portfolio;
import com.taras.vizitkaapi.repository.PortfolioRepositoryJPA;

@ExtendWith(MockitoExtension.class)
class PortfolioServiceImplTest {
	
	@Mock
	private PortfolioRepositoryJPA portfolioRepository;
	
	@InjectMocks
	PortfolioServiceImpl portfolioService;
	
	List<Portfolio> allPortfolios;
	
	@BeforeEach
    void setUp() {
		Portfolio thePortfolio = new Portfolio();
    	thePortfolio.setFirstName("Alex");
    	thePortfolio.setLastName("Kont");
		
    	allPortfolios = Arrays.asList(thePortfolio);
    }
	
	
	@Test
	void findAll() {
		when(portfolioRepository.findAll()).thenReturn(allPortfolios);

        List<Portfolio> portfolios = portfolioService.findAll();

        assertEquals(portfolios.size(), 1);
        verify(portfolioRepository, times(1)).findAll();
	}
	
	@Test
	void findById() {
		when(portfolioRepository.findById(1L)).thenReturn(Optional.of(allPortfolios.get(0)));

		Optional<Portfolio> portfolio = portfolioService.findById(1L);

        assertEquals(portfolio.get(), allPortfolios.get(0));
        verify(portfolioRepository, times(1)).findById(1L);
	}

}
