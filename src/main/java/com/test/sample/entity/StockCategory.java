package com.test.sample.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "stock_category", catalog = "rahmandb")
public class StockCategory implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

//	@EmbeddedId
//	private StockCategoryId pk = new StockCategoryId();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "STOCK_ID")
	private Stock stock;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID")
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
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", nullable = false, length = 10)
	private Date createdDate;
	
	@Column(name = "CREATED_BY", nullable = false, length = 10)
	private String createdBy;
	
//	public StockCategoryId getPk() {
//		return pk;
//	}
//
//	public void setPk(StockCategoryId pk) {
//		this.pk = pk;
//	}
//	
//	@Transient
//	public Stock getStock() {
//		return getPk().getStock();
//	}
//
//	public void setStock(Stock stock) {
//		getPk().setStock(stock);
//	}
//
//	@Transient
//	public Category getCategory() {
//		return getPk().getCategory();
//	}
//
//	public void setCategory(Category category) {
//		getPk().setCategory(category);
//	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
