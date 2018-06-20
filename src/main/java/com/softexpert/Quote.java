package com.softexpert;

import java.math.BigDecimal;

public class Quote {

	private String stock;

	private BigDecimal price;

	public Quote(String stock, Double price) {
		super();
		this.stock = stock;
		this.price = BigDecimal.valueOf(price);
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
