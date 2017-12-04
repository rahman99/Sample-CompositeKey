package com.test.sample.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.test.sample.entity.Category;


public interface CategoryDao extends PagingAndSortingRepository<Category, Integer> {

}
