package com.example.person.person.config;

import java.util.function.Supplier;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.example.person.person.publisher.CustomEventPublisher;

@Configuration
public class RestTemplateConfiguration {
	
	@Bean(name = "restTemplate")
	RestTemplate getRestTemplate() {
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		return restTemplateBuilder.requestFactory(() -> new BufferingClientHttpRequestFactory(new HttpComponentsClientHttpRequestFactory())).build();
	}
}
