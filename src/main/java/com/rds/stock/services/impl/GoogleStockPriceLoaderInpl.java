/**
 * 
 */
package com.rds.stock.services.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rds.stock.dao.StockPriceDao;
import com.rds.stock.domain.Stock;
import com.rds.stock.domain.StockPrice;
import com.rds.stock.dto.GoogleStockResponse;
import com.rds.stock.services.StockPriceLoader;
import com.rds.stock.util.HeaderRequestInterceptor;

/**
 * @author Nazmul Hassan
 *
 */
@Service
public class GoogleStockPriceLoaderInpl implements StockPriceLoader{

	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	StockPriceDao stockPriceDao;
	
	private static String GOOGLE_FINANCE_END_POINT = "http://finance.google.com/finance/info?client=ig&q=NASDAQ%3A";
	
	@Override
	@Transactional
	public void loadPrice(List<Stock> stocks) {
		List<String> tickers = new ArrayList<String>();
		for(Stock st: stocks){
			tickers.add(st.getSymbol());
		}
		RestTemplate restTemplate = getRestTemplate();
		String endPointWithParam = GOOGLE_FINANCE_END_POINT + String.join(",", tickers);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(endPointWithParam, String.class);
		List<GoogleStockResponse> responses = getResponseObject(responseEntity.getBody(), objectMapper);
		Map<String, BigDecimal> tickerPriceMap = getPriceMap(responses);
		List<StockPrice> prices = new ArrayList<StockPrice>();
		Date currentDate = new Date();
		for(Stock st: stocks){
			BigDecimal price = tickerPriceMap.get(st.getSymbol());
			StockPrice newPrice = new StockPrice(price, currentDate, st.getSymbol());
			prices.add(newPrice);
			st.setLatestPrice(newPrice);
			
		}
		if(! CollectionUtils.isEmpty(prices)){
			stockPriceDao.save(prices);
		}
	}
	
	private static void registerMessageConverter(RestTemplate restTemplate){
		MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
		jsonHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_HTML));
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		
		jsonHttpMessageConverter.setObjectMapper(objectMapper);
		restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
	}
	
	private static RestTemplate getRestTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		registerMessageConverter(restTemplate);
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new HeaderRequestInterceptor("Accept", MediaType.TEXT_HTML_VALUE));
		restTemplate.setInterceptors(interceptors);
		
		return restTemplate;
	}
	
	private static List<GoogleStockResponse> getResponseObject(String content, ObjectMapper jacksonObjectMapper){
		try {
			content = content.substring(3);
			System.out.println(content);
			GoogleStockResponse[] stockResponses = (GoogleStockResponse[]) jacksonObjectMapper.readValue(content, GoogleStockResponse[].class);
			return Arrays.asList(stockResponses);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}
	
	private Map<String, BigDecimal> getPriceMap(List<GoogleStockResponse> stockPrices){
		Map<String, BigDecimal> tickerWisePriceMap = new HashMap<String, BigDecimal>();
		for(GoogleStockResponse stResponse: stockPrices){
			tickerWisePriceMap.put(stResponse.getT(), stResponse.getL());
		}
		return tickerWisePriceMap;
	}
	
}