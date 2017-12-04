package com.test.sample.Sample;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.sample.entity.Category;
import com.test.sample.entity.Stock;
import com.test.sample.entity.StockCategory;
import com.test.sample.repository.CategoryDao;
import com.test.sample.repository.StockCategoryDao;
import com.test.sample.repository.StockDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockCategoryTest {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private StockCategoryDao stockCategoryDao;
	
}
