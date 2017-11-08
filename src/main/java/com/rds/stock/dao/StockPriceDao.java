/**
 * 
 */
package com.rds.stock.dao;

import org.springframework.data.repository.CrudRepository;

import com.rds.stock.domain.StockPrice;

/**
 * @author Nazmul Hassan
 *
 */
public interface StockPriceDao extends CrudRepository<StockPrice, Long>{

}
