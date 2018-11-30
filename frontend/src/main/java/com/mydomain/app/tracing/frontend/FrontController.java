package com.mydomain.app.tracing.frontend;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FrontController {
	
	private static final Logger LOG = LoggerFactory.getLogger(FrontController.class);
	private static final String URL = "http://localhost:8080/v1/back/test";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/v1/front/test", method = RequestMethod.GET)
	public String test() throws Exception {
	
		try {
			String s = restTemplate.getForObject(URL, String.class);
			LOG.info("get message from backend: {}", s);
			
			Thread.sleep(new Random().nextInt(1000));
			
			return "Message from backend: " + s;
		} catch (Exception e) {
			return "Error!";
		}
	}
}
