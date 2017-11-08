/**
 * 
 */
package com.rds.stock.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Nazmul Hassan
 *
 */
@Entity
@Table(name = "rds_stocks")
public class Stock {

	@Id
	@GeneratedValue
	@Column(name = "identifier")
	Long id;
	
	@Column(name = "symbol")
	String symbol;
	
	@Column(name = "name")
	String stockName;
	
	@Column (name = "market_cap")
	BigDecimal marketCap;
	
	@Column(name ="sector")
	String sector;
	
	@Column(name = "industry")
	String industry;

	@Transient
	private StockPrice latestPrice;
	
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

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public BigDecimal getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(BigDecimal marketCap) {
		this.marketCap = marketCap;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public StockPrice getLatestPrice() {
		return latestPrice;
	}

	public void setLatestPrice(StockPrice latestPrice) {
		this.latestPrice = latestPrice;
	}
	
	/*@PostLoad
	private void onLoad(){
		if(this.latestPrice == null && !StringUtils.isEmpty(this.getSymbol())){
			
		}
	}*/
}
