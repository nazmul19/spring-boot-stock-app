/**
 * 
 */
package com.rds.stock.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Nazmul Hassan
 *
 */
@Entity
@Table (name = "rds_stock_prices")
public class StockPrice {
	
	@Id
	@GeneratedValue
	@Column (name = "identifier")
	private Long id;
	
	
	@Column (name = "symbol")
	private String symbol;
	
	@Column (name = "timestamp")
	private Date timeStamp;
	
	@Column (name = "price")
	private BigDecimal price;

	public StockPrice(){}
	public StockPrice(BigDecimal price, Date timestamp, String symbol){
		this.price = price;
		this.symbol = symbol;
		this.timeStamp = timestamp;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
