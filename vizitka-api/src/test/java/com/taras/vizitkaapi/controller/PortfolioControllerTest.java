package com.taras.vizitkaapi.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.taras.vizitkaapi.entity.Portfolio;
import com.taras.vizitkaapi.service.InterestService;
import com.taras.vizitkaapi.service.PortfolioService;
import com.taras.vizitkaapi.service.SkillService;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(PortfolioController.class)
class PortfolioControllerTest {
	
	
	@MockBean
	private PortfolioService portfolioService;
	
	@MockBean
	private SkillService skillService;
	
	@MockBean
	private InterestService interestService;
	
	@Autowired
    private MockMvc mvc;
	
	List<Portfolio> allPortfolios;
	
	@BeforeEach
    void setUp() {
    	Portfolio thePortfolio = new Portfolio();
    	thePortfolio.setFirstName("Alex");
    	thePortfolio.setLastName("Kont");
		
    	allPortfolios = Arrays.asList(thePortfolio);
    }
	
	@Test
	void getAllPortfolios() throws Exception {

		when(portfolioService.findAll()).thenReturn(allPortfolios);
    	mvc.perform(get("/api/portfolios")
    		.contentType(MediaType.APPLICATION_JSON))
    		.andExpect(status().isOk())
    		.andExpect(content()
    		.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
    		.andExpect(jsonPath("$[0].firstName", is("Alex")));
	}
	
	@Test
	void getPortfolio() throws Exception {

		when(portfolioService.findById(1L)).thenReturn(Optional.of(allPortfolios.get(0)));
    	
		mvc.perform(get("/api/portfolios/1")
    		.contentType(MediaType.APPLICATION_JSON))
    		.andExpect(status().isOk())
    		.andExpect(content()
    		.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
    		.andExpect(jsonPath("$.firstName", is("Alex")));
	}
	
	@Test
	void getPortfolioNotFound() throws Exception {

		when(portfolioService.findById(1L)).thenReturn(Optional.ofNullable(null));
    	
		mvc.perform(get("/api/portfolios/1")
			.contentType(MediaType.APPLICATION_JSON))
    		.andExpect(status().isNotFound());
	}

}
