package com.techprimers.stock.dbservice.model;

public class Quote {

	private Integer id;
	private String userName;
	private String quote;

	public Quote() {
	}

	public Quote(Integer id, String userName, String quote) {
		super();
		this.id = id;
		this.userName = userName;
		this.quote = quote;
	}

	public Quote(String userName, String quote) {
		this.userName = userName;
		this.quote = quote;
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", userName=" + userName + ", quote=" + quote + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
}
