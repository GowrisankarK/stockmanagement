package com.project.inventory.stockmanagement.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "stockdetail")
public class StockDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="stock_name")
	private String stockName;
	@Column(name="stock_owner_id", nullable=false)
	private Long stockOwnerId;
	@Column(name="stock_owner_name")
	private String stockOwnerName;
	@Column(name="quantity")
	private Long quantity;
	@Column(name="stock_value", nullable=false)
	private Long stockValue;
	@Column(name="date")
	private LocalDate date;
	@Column(name="remarks")
	private String remarks;

	public StockDetail() {
		super();
	}

	public StockDetail(Long id, String stockName, Long stockOwnerId, String stockOwnerName, Long quantity,
			Long stockValue, LocalDate date, String remarks) {
		super();
		this.id = id;
		this.stockName = stockName;
		this.stockOwnerId = stockOwnerId;
		this.stockOwnerName = stockOwnerName;
		this.quantity = quantity;
		this.stockValue = stockValue;
		this.date = date;
		this.remarks = remarks;
	}

	public Long getId() {
		return id;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Long getStockOwnerId() {
		return stockOwnerId;
	}

	public void setStockOwnerId(Long stockOwnerId) {
		this.stockOwnerId = stockOwnerId;
	}

	public String getStockOwnerName() {
		return stockOwnerName;
	}

	public void setStockOwnerName(String stockOwnerName) {
		this.stockOwnerName = stockOwnerName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getStockValue() {
		return stockValue;
	}

	public void setStockValue(Long stockValue) {
		this.stockValue = stockValue;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StockDetail [id=");
		builder.append(id);
		builder.append(", stockName=");
		builder.append(stockName);
		builder.append(", stockOwnerId=");
		builder.append(stockOwnerId);
		builder.append(", stockOwnerName=");
		builder.append(stockOwnerName);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", stockValue=");
		builder.append(stockValue);
		builder.append(", date=");
		builder.append(date);
		builder.append(", remarks=");
		builder.append(remarks);
		builder.append("]");
		return builder.toString();
	}
	
}
