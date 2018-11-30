package com.mydomain.app.tracing.backend;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
	
	private static final int SEED = 3000;
	
	@RequestMapping(value = "/v1/back/test", method = RequestMethod.GET)
	public String test() throws Exception {
		
		int n = new Random().nextInt(SEED);
		//if (n < SEED * 0.1) {
		//	throw new RuntimeException("sample exception message");
		//}
		
		LOG.info("backend service, sleep time: {}", n);
		Thread.sleep(n);

		return "Hello, sleep time: " + n;
	}
}
