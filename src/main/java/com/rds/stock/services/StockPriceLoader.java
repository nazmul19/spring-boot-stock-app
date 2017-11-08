/**
 * 
 */
package com.rds.stock.services;

import java.util.List;

import com.rds.stock.domain.Stock;

/**
 * @author Nazmul Hassan
 *
 */
public interface StockPriceLoader {

	public void loadPrice(List<Stock> stocks);
}
