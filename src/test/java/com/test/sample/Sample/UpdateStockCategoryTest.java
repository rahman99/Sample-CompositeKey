package com.test.sample.Sample;

import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.sample.entity.Stock;
import com.test.sample.entity.StockCategory;
import com.test.sample.repository.CategoryDao;
import com.test.sample.repository.StockCategoryRepository;
import com.test.sample.repository.StockDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UpdateStockCategoryTest {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private StockCategoryRepository stockCategoryDao;
	
	@Test
	public void updateExistingStock(){
		Stock stock2 = stockDao.findOne(2);
		Set<StockCategory> stockCategories  =stock2.getStockCategories();
		for(StockCategory sc : stockCategories){
			
		}
	}
}
