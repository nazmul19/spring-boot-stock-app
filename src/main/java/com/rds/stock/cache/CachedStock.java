package com.rds.stock.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rds.stock.domain.Stock;

public class CachedStock {

	private static Map<String, Stock> favouriteStockMap = new HashMap<String, Stock>();
	
	public static boolean addToFavoriteList(Stock stock){
		return favouriteStockMap.put(stock.getSymbol(), stock) != null;
	}
	
	public static List<Stock> getFavouriteStocks(){
		return new ArrayList<Stock> (favouriteStockMap.values());
	}
}
