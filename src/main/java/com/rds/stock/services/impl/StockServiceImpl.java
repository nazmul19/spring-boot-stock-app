/**
 * 
 */
package com.rds.stock.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rds.stock.cache.CachedStock;
import com.rds.stock.dao.StockDao;
import com.rds.stock.domain.Stock;
import com.rds.stock.services.StockPriceLoader;
import com.rds.stock.services.StockService;

/**
 * @author Nazmul Hassan
 *
 */
@Service
@Transactional
public class StockServiceImpl implements StockService{

	@Autowired
	StockDao stockDao;
	
	@Autowired
	StockPriceLoader priceLoader;
	
	@Override
	public Page<Stock> listAllStockByPage(Pageable pageable) {
		Page<Stock> pageStocks = stockDao.findAll(pageable);
		priceLoader.loadPrice(pageStocks.getContent());
		return pageStocks;
	}

	@Override
	
	public List<Stock> getFavouriteList() {
		List<Stock> favouriteList = CachedStock.getFavouriteStocks();
		priceLoader.loadPrice(favouriteList);
		return favouriteList;
	}

	@Override
	public boolean addIntoFavouriteList(String symbol) {
		Stock stock = stockDao.findBySymbol(symbol);
		return CachedStock.addToFavoriteList(stock);
	}
	
}
