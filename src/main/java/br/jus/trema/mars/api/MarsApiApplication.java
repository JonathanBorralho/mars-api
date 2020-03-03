package br.jus.trema.mars.api;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import br.jus.trema.mars.api.config.RequestResponseLoggingInterceptor;

@SpringBootApplication
@EnableCaching
public class MarsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsApiApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder
				.interceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()))
				.build();
	}
	
}
