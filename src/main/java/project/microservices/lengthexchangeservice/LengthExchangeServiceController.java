package project.microservices.lengthexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LengthExchangeServiceController {
	
	private Logger logger = LoggerFactory.getLogger(LengthExchangeServiceController.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/length-exchange/from/{from}/to/{to}")
	public  ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
		logger.info("{} to {} by retrieveExchangeValue", from, to);
		
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		return exchangeValue;
		
	}
	

}
