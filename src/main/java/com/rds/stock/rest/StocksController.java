/**
 * 
 */
package com.rds.stock.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.stock.domain.Stock;
import com.rds.stock.services.StockService;

/**
 * @author Nazmul Hassan
 *
 */
@RestController
@RequestMapping("/stocks")
public class StocksController {

	@Autowired
	StockService stockService;
		
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Page<Stock> list(Pageable pageable){
		return stockService.listAllStockByPage(pageable);
	}
	
	@RequestMapping(value = "/favourites", method = RequestMethod.GET)
	public List<Stock> getFavouriteList(){
		return stockService.getFavouriteList();
	}
	
	@RequestMapping(value = "/{symbol}/favourite", method = RequestMethod.PUT)
	public boolean addIntoFavouriteList(@PathVariable("symbol") String symbol){
		return stockService.addIntoFavouriteList(symbol);
	}
}
