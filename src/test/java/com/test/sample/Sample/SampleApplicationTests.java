package com.test.sample.Sample;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.sample.entity.Category;
import com.test.sample.entity.Stock;
import com.test.sample.entity.StockCategory;
import com.test.sample.repository.CategoryDao;
import com.test.sample.repository.StockDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleApplicationTests {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private StockDao stockDao;

//	@Test
	public void sample() {
		Stock stock = new Stock();
		stock.setStockCode("001");
		stock.setStockName("food");

		Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
		//new category, need save to get the id first
		categoryDao.save(category1);

		StockCategory stockCategory = new StockCategory();
		stockCategory.setStock(stock);
		stockCategory.setCategory(category1);
		stockCategory.setCreatedDate(new Date()); //extra column
		stockCategory.setCreatedBy("system"); //extra column

		stock.getStockCategories().add(stockCategory);
		
		stockDao.save(stock);
	}
	
//	@Test
	public void addCategory(){
		Category category1 = new Category("PRODUCER", "producer COMPANY");
		//new category, need save to get the id first
		categoryDao.save(category1);
		Category category2 = new Category("supplier", "supplier COMPANY");
		//new category, need save to get the id first
		categoryDao.save(category2);
		Category category3 = new Category("warehouse", "warehouse COMPANY");
		//new category, need save to get the id first
		categoryDao.save(category3);
	}
	
//	@Test
	public void addStock(){
		 Stock stock = new Stock();
		 stock.setStockCode("005");
		 stock.setStockName("drink2");
		 
		 Stock stock1 = new Stock();
		 stock1.setStockCode("004");
		 stock1.setStockName("snack2");

		 Category category1 = categoryDao.findOne(4);
		 
		 StockCategory stockCategory = new StockCategory();
		 stockCategory.setStock(stock);
		 stockCategory.setCategory(category1);
		 stockCategory.setCreatedDate(new Date()); //extra column
		 stockCategory.setCreatedBy("system"); //extra column
		 
		 stock.getStockCategories().add(stockCategory);
		 stockDao.save(stock);
		 
		 StockCategory stockCategory1 = new StockCategory();
		 stockCategory1.setStock(stock1);
		 stockCategory1.setCategory(category1);
		 stockCategory1.setCreatedDate(new Date()); //extra column
		 stockCategory1.setCreatedBy("system"); //extra column
		 
		 stock1.getStockCategories().add(stockCategory1);
		 stockDao.save(stock1);

	}
	
	///saat menjalankan test update jadi error
	@Test
	public void updatesample(){
		Category category2 = categoryDao.findOne(2);
		Category category3 = categoryDao.findOne(3);
		Assert.assertNotNull(category2);
		Assert.assertNotNull(category3);
		
		Stock stock = stockDao.findOne(1);
		Assert.assertNotNull(stock);
		
		StockCategory stockCategory1 = new StockCategory();
		stockCategory1.setStock(stock);
		stockCategory1.setCategory(category2);
		stockCategory1.setCreatedDate(new Date()); //extra column
		stockCategory1.setCreatedBy("system"); //extra column
		
		StockCategory stockCategory2 = new StockCategory();
		stockCategory2.setStock(stock);
		stockCategory2.setCategory(category3);
		stockCategory2.setCreatedDate(new Date()); //extra column
		stockCategory2.setCreatedBy("system"); //extra column
		
		Set<StockCategory> stockCategories = new HashSet<StockCategory>();
		stockCategories.add(stockCategory1);
		stockCategories.add(stockCategory2);
		
		stock.setStockCategories(stockCategories);
		
		stockDao.save(stock);
	}

}
