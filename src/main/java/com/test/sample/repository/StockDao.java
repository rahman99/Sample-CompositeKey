package com.test.sample.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.test.sample.entity.Stock;

public interface StockDao extends PagingAndSortingRepository<Stock, Integer> {

}
