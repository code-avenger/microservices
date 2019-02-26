package com.techprimers.stock.stockservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/stock")
public class StockResource {

	@Autowired
	RestTemplate restTemplate;

	int index = 1000;

	@GetMapping("/{username}")
	public List<Stock> getStock(@PathVariable("username") final String userName) {

		ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://db-service/rest/db/" + userName,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
				});

		List<String> quotes = quoteResponse.getBody();
		System.out.println(" quoteResponse: " + quotes);
		return quotes.stream().map(this::getStockPrice).collect(Collectors.toList());
	}

	private Stock getStockPrice(String quote) {

		Stock stock = new Stock(quote);
		stock.setValue(String.valueOf(index++));

		return stock;

	}

	class Stock {
		private String name;
		private String value;

		Stock(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Stock [name=" + name + ", value=" + value + "]";
		}

		public Stock() {
			super();
		}

	}
}
