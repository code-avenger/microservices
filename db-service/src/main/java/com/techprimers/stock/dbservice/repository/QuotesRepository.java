package com.techprimers.stock.dbservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.techprimers.stock.dbservice.model.Quote;

@Repository
public class QuotesRepository {

	List<Quote> quotelist = new ArrayList<>();
	int index = 1;

	public List<Quote> findByUserName(String username) {
		return quotelist.stream().filter(quote -> quote.getUserName().equals(username)).collect(Collectors.toList());

	}

	public void save(Quote quote) {
		System.out.println("****************** save");
		quote.setId(index++);
		quotelist.add(quote);
		System.out.println("****************** save1");
		quotelist.forEach(quote1 -> {
			System.out.println(quote1.getId());
		});
	}

	public void delete(List<Quote> quotes) {

		for (Quote quote : quotes) {
			quotelist.remove(quote);
		}
	}

	public List<String> getQuotesByUserName(String username) {
		return quotelist.stream().filter(quote -> quote.getUserName() == username).map(Quote::getUserName)
				.collect(Collectors.toList());

	}

	@PostConstruct
	public void generateData() {

		quotelist.add(new Quote(index++, "sudeep", "AMZN"));
		quotelist.add(new Quote(index++, "sudeep", "CSCO"));
		quotelist.add(new Quote(index++, "sudeep", "MSFT"));

	}

}
