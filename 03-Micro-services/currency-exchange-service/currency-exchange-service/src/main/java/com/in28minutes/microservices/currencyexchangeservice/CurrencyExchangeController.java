package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment enviornment;

	@Autowired
	private CurrencyExchangeRepository repository;

	@GetMapping("/currency-exchnage/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to) {

		// CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to,
		// BigDecimal.valueOf(50));
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

		if (currencyExchange == null) {
			throw new RuntimeException("unable to find data for from" + from + " to " + to);
		}

		String port = enviornment.getProperty("local.server.port");
		currencyExchange.setEnviornment(port);

		return currencyExchange;
	}
}
