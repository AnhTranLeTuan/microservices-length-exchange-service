package project.microservices.lengthexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	// We can use "default" name for default configuration for @Retry, @CircuitBreaker and @RateLimiter
	@GetMapping("/example-api")
	@Retry(name = "retry-example", fallbackMethod = "response")
	//@CircuitBreaker(name = "circuit-breaker-example", fallbackMethod = "response")
	public String example_api(){
		logger.info("Request Received111111111111111111111111");
		// This below code will make the function fail to test circuit breaker's features 
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-uri", String.class);
		return forEntity.getBody();
	}
	
	@GetMapping("/other-example-api")
	@RateLimiter(name = "rate-limiter-example")
	public String other_example_api(){
		logger.info("Request Received111111111111111111111111");
		return "success";
	}
	
	public String response(Exception ex) {
		return "response";
	}

}
