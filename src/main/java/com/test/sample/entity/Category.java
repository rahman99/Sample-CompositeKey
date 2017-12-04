package com.test.sample.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "category", catalog = "rahmandb", uniqueConstraints = {
		@UniqueConstraint(columnNames = "NAME") })
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	private Integer categoryId;
	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "[DESC]", nullable = false)
	private String desc;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade=CascadeType.ALL)
	private Set<StockCategory> stockCategories = new HashSet<>();

	public Category(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	
	public Category(){}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set<StockCategory> getStockCategories() {
		return stockCategories;
	}

	public void setStockCategories(Set<StockCategory> stockCategories) {
		this.stockCategories = stockCategories;
	}

}
