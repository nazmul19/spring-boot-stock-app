/**
 * 
 */
package com.rds.stock.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rds.stock.dao.StockDaoCustom;
import com.rds.stock.domain.Stock;

/**
 * @author Nazmul Hassan
 *
 */
public class StockDaoCustomImpl implements StockDaoCustom{
	@PersistenceContext private EntityManager em;
	
	@Override
	public Stock findBySymbol(String symbol) {
		String sql = "select st from Stock st where st.symbol = '%s'";
		return (Stock) this.em.
				createQuery(String.format(sql, symbol)).
				getSingleResult();
		
	}

}
