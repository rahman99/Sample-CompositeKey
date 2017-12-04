package com.test.sample.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class StockCategoryId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Stock stock;
	
	@ManyToOne
    private Category category;

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
