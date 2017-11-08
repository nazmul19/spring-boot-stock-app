/**
 * 
 */
package com.rds.stock.dao;

import com.rds.stock.domain.Stock;

/**
 * @author Nazmul Hassan
 *
 */
public interface StockDaoCustom {
	public Stock findBySymbol(String symbol);
}
