package br.jus.trema.mars.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.jus.trema.mars.api.model.ApiResponseModel;
import br.jus.trema.mars.api.model.Sol;
import br.jus.trema.mars.api.service.SolService;

@Service
public class ApiSolService implements SolService {
	
	private static final String API_URL = "https://api.nasa.gov/insight_weather/?feedtype=json&ver=1.0&api_key=";
	
	@Value("${nasa.api.key:DEMO_KEY}")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Cacheable(value = "sols")
	@Override
	public List<Sol> findAll() {
		ApiResponseModel model = restTemplate.getForObject(API_URL.concat(apiKey), ApiResponseModel.class);
		return model.getSols();
	}
	
	
}

