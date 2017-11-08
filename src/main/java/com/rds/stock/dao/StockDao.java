/**
 * 
 */
package com.rds.stock.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.rds.stock.domain.Stock;

/**
 * @author Nazmul Hassan
 *
 */
@Transactional
public interface StockDao extends PagingAndSortingRepository<Stock, Long>, StockDaoCustom{
}
