package com.mydomain.app.tracing.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Main {

	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		return builder.setReadTimeout(10000).setConnectTimeout(10000).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
