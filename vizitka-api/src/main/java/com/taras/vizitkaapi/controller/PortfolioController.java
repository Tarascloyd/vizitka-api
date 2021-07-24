package com.taras.vizitkaapi.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taras.vizitkaapi.entity.Interest;
import com.taras.vizitkaapi.entity.Portfolio;
import com.taras.vizitkaapi.entity.Skill;
import com.taras.vizitkaapi.service.InterestService;
import com.taras.vizitkaapi.service.PortfolioService;
import com.taras.vizitkaapi.service.SkillService;

@RestController
@RequestMapping("api/portfolios")
public class PortfolioController {
	
	private PortfolioService portfolioService;
	private SkillService skillService;
	private InterestService interestService;
	
	public PortfolioController(PortfolioService portfolioService, SkillService skillService,
			InterestService interestService) {
		this.portfolioService = portfolioService;
		this.skillService = skillService;
		this.interestService = interestService;
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
	
	@GetMapping("/{id}/skills")
	public ResponseEntity<Page<Skill>> getSkillsByPortfolioId(@PathVariable("id") Long id, Pageable pageable) {
		
		Page<Skill> result = skillService.findByPortfolioId(id, pageable);
		if (result.getContent().isEmpty()) {
			return new ResponseEntity<Page<Skill>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Page<Skill>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/skills/search")
	public ResponseEntity<Page<Skill>> getSkillsByPortfolioId(
			@PathVariable("id") Long id,
			@RequestParam("name") String name,
			Pageable pageable) {
		Page<Skill> result;
		if (name.trim().isEmpty()) {
			result = skillService.findByPortfolioId(id, pageable);
		} else {
			result = skillService.findByPortfolioSearchSkillName(id, name, pageable);
		}
		if (result.getContent().isEmpty()) {
			return new ResponseEntity<Page<Skill>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Page<Skill>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/interests")
	public ResponseEntity<Set<Interest>> getInterestsByPortfolioId(@PathVariable("id") Long id) {
		Set<Interest> result = interestService.findByPortfolioId(id);
			
		if (result.isEmpty()) {
			return new ResponseEntity<Set<Interest>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Set<Interest>>(result, HttpStatus.OK);
	}
	
}
