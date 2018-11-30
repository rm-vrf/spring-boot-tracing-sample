package com.mydomain.app.tracing.frontend;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FrontController {

	private static final Logger LOG = LoggerFactory.getLogger(FrontController.class);

	@Value("${back.url}")
	private String back;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/front/api/v1/test", method = RequestMethod.GET)
	public String test() throws Exception {

		String s = restTemplate.getForObject(back + "/back/api/v1/test", String.class);
		LOG.info("get message: {}", s);

		String s2 = restTemplate.getForObject(back + "/back/api/v1/test2", String.class);
		LOG.info("get message: {}", s2);

		Thread.sleep(new Random().nextInt(1000));

		return "Message from backend: [\"" + s + "\", \"" + s2 + "\"]";
	}

}
