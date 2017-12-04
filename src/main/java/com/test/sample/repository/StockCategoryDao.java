package com.test.sample.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.test.sample.entity.StockCategory;

public interface StockCategoryDao extends PagingAndSortingRepository<StockCategory, Integer>{

}
