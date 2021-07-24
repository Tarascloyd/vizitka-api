package com.taras.vizitkaapi.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taras.vizitkaapi.entity.Portfolio;
import com.taras.vizitkaapi.service.PortfolioService;

@RestController
@RequestMapping("api/portfolios")
public class PortfolioController {
	
	private PortfolioService portfolioService;

	public PortfolioController(PortfolioService portfolioService) {
		this.portfolioService = portfolioService;
		Portfolio portfolio1 = new Portfolio("Taras", "Shetsov", "Novosibirsk");
		Portfolio portfolio2 = new Portfolio("Victor", "Petrov", "Tomsk");
		portfolioService.save(portfolio1);
		portfolioService.save(portfolio2);
	}
	
	@GetMapping({"/", ""})
	public @ResponseBody Iterable<Portfolio> getAllPortfolios() {
	    
		return portfolioService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Portfolio> getPortfolioById(@PathVariable("id") Long id) {
		Optional<Portfolio> result = portfolioService.findById(id);
			
		if (!result.isPresent()) {
			return new ResponseEntity<Portfolio>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Portfolio>(result.get(), HttpStatus.OK);
	}
	
}
