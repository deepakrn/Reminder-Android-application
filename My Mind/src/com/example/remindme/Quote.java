package com.example.remindme;

public class Quote {
	private String header;
	private String quote;
Quote(String header, String quote){
	this.quote=quote;
	this.header=header;
}

public String getHeader() {
	return header;
}

public void setHeader(String header) {
	this.header = header;
}

public String getQuote() {
	return quote;
}
public void setQuote(String quote) {
	this.quote = quote;
}

}
