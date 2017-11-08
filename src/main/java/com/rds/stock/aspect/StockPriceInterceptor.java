/**
 * 
 *//*
package com.rds.stock.aspect;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rds.stock.domain.Stock;
import com.rds.stock.services.StockPriceLoader;

*//**
 * @author Nazmul Hassan
 *
 *//*
@Aspect
@Component
public class StockPriceInterceptor {

	@Autowired
	StockPriceLoader priceLoader;
	
	@Around("@annotation(com.rds.stock.aspect.PriceInterceptor)")
	public Object logTime(ProceedingJoinPoint pjp) 
	throws Throwable {
		Object result = pjp.proceed();
		if(result instanceof ArrayList){
			List<Stock> stocks = (List<Stock>) result;
			priceLoader.loadPrice(stocks);
			return stocks;
		}
		
		return result;
	}
}*/