package com.rds.stock.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rds.stock.domain.Stock;

public interface StockService {
	Page<Stock> listAllStockByPage(Pageable pageable);
	boolean addIntoFavouriteList(String symbol);
	List<Stock> getFavouriteList();
}
