package br.jus.trema.mars.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.jus.trema.mars.api.model.ApiResponseModel;
import br.jus.trema.mars.api.model.Sol;
import br.jus.trema.mars.api.service.SolService;

@Service
public class ApiSolService implements SolService {
	
	private static String API_URL = "https://api.nasa.gov/insight_weather/?api_key=DEMO_KEY&feedtype=json&ver=1.0";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	@Cacheable("sols")
	public List<Sol> findAll() {
		//restTemplate.getForEntity(API_URL, ApiResponseModel.class);
		ApiResponseModel model = restTemplate.getForObject(API_URL, ApiResponseModel.class);
		return model.getSols();
	}
	
	
}

